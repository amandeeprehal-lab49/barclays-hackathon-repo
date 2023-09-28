package com.ion.barclaysapi.usecases.uc1;

import java.io.File;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ion.barclaysapi.client.api.TradeExecutionApiApi;
import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.api.TradeSettlementApiApi;
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.model.BusinessEventData;
import com.ion.barclaysapi.client.model.BusinessEventDto;
import com.ion.barclaysapi.client.model.RepoTradeExecutionSubmissionRequest;
import com.ion.barclaysapi.client.model.RepoTradeSubmissionResponse;
import com.ion.barclaysapi.client.model.SettlementRequestBody;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryRequest;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryResponse;
import com.ion.barclaysapi.client.model.TradeWorkflowStatusResponse;
import com.ion.barclaysapi.client.model.WorkflowEvent;
import com.ion.barclaysapi.client.model.WorkflowEventData;
import com.ion.barclaysapi.hedera.HederaFunctions;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;

import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.product.template.EconomicTerms;
import cdm.product.template.TradableProduct;

public class UseCase4Orchestrator {

	public static void main(String[] args) {
		try {
			new UseCase4Orchestrator().demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void demo() throws Exception {

		// A new trade is agreed
		RepoTradeExecutionSubmissionRequest trade = newTradeAgreed();
		
		// Simulate this is agreed DLT
		submitTradeToDLT(trade);
		
		// Simulate to have received an event from the DLT, saying that a new contract has been formed. 
		submitTradeToMatchingService(trade);
		
		if (tradeIsMatched(trade)) {
		
			// We automatically simulate that the trade is settled in DLT.
			// We can't settle directly in DLT at the moment, so this orchestrator will automatically settle in DLT.
			TradeBusinessEventsQueryResponse contractFormedEvent = getTradeFormationEventFromTradeMatchingService(trade);
			
			// This is for demo purpose - we can't generate the hash in DLT at the moment, so we delegate to Trade Matching API to do it for us.
			updateTradeHashInHederaForNewContract(contractFormedEvent);
			
			// Simulate a settlement event occurring in DLT
			settleStartLegInHedera(trade, contractFormedEvent);
				
			// After trade is settled in DLT, notify the Trade Settlement Service
			settleStartLegInSettlementSystem(contractFormedEvent);
				
			// This is for demo purpose - we can't generate the hash in DLT at the moment, so we delegate to Trade Matching API to do it for us.
			updateTradeHashInHederaForSettlement();
				
			// TODO do the same for end leg
		}
	}


	// Proxies to remote services
	private TradeExecutionApiApi executionAPI; // Trade Matching Service
	private TradeQueryApiApi queryAPI; // Trade Query API
	private TradeSettlementApiApi settlementAPI; // Trade Settlement Service
	private HederaFunctions hedera; // DLT - Hedera
	
	public UseCase4Orchestrator() {
		this.executionAPI = new TradeExecutionApiApi(newAPIClient());
		this.queryAPI = new TradeQueryApiApi(newAPIClient());
		this.settlementAPI = new TradeSettlementApiApi(newAPIClient());
		this.hedera = new HederaFunctions();
	}
	
	private static ApiClient newAPIClient() {
		ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");
        defaultClient.setDebugging(true);
        return defaultClient;
	}
		
	// Read a new trade from a file	
	private RepoTradeExecutionSubmissionRequest newTradeAgreed() throws Exception {
		// Sample file content:
		// {"trade_id": "ABCDQN1435RKX0", "buyer": {"buyer_name": "CLIENT01", "buyer_lei": "CLIENT01-LEI02", "buyer_account": "CLIENT01-ACCOUNT02"}, "seller": {"seller_name": "DEALER02", "seller_lei": "DEALER02-LEI01", "seller_account": "DEALER02-ACCOUNT01"}, "trade_details": {"trade_date": "2023-10-16", "effective_date": "2023-10-16", "maturity_date": "2023-10-18", "repo_rate": 0.05, "rate_daycount_convention": "ACT_360", "collateral_id": "GBTHQ4XCY21", "collateral_notional": 2000000, "collateral_haircut": 0.02, "collateral_dirty_price": "99.00", "trade_ccy": "GBP", "cash_amount": "1940400.00", "termination_cash_amount": "1940665.81"}}
		
		File inputFile = new File("C:\\Users\\dlevantesi\\RepoHack2023\\RepoHack2023_Files\\new_trades\\new_trade.json");
	
		System.out.println("New trade agreed");
		ObjectMapper objectMapper = new ObjectMapper();
		RepoTradeExecutionSubmissionRequest trade = objectMapper.readValue(inputFile, RepoTradeExecutionSubmissionRequest.class);

		return trade;
	}
	
	private void submitTradeToDLT(RepoTradeExecutionSubmissionRequest trade) throws Exception {
		System.out.println("Creating smart contract for trade: " + trade.getTradeId());
		hedera.updateTradeMatching(
				trade.getSeller().getSellerName(), // role, for demo purposes we assume to be the seller (repo trade)
	            trade.getTradeId(), // tradeId
	            trade.getBuyer().getBuyerName(), // cpty, for demo purposes they're the buyers (reverse repo from their perspective)
	            trade.getTradeDetails().getTradeDate(), // Event date
	            "New", // EventType
	            "", // cdmHash, will be generated later
	            "" // lineageHashnull, will be generated later 
				);
		System.out.println("Smart contract created for trade: " + trade.getTradeId());
	}
	
	private void submitTradeToMatchingService(RepoTradeExecutionSubmissionRequest trade) throws Exception {
		String tradeId = trade.getTradeId();
		String buyerName = trade.getBuyer().getBuyerName();
		String sellerName = trade.getSeller().getSellerName();
		String tradeDate = trade.getTradeDetails().getTradeDate();
		String maturityDate = trade.getTradeDetails().getMaturityDate();

		String xSimulationDate = trade.getTradeDetails().getTradeDate();

		{
			UUID xApiRequestId = UUID.randomUUID();
			System.out.println(String.format("Submitting trade to Trade Matching servicefor [%s] as-of [%s]. Request id: [%s].", sellerName, xSimulationDate, xApiRequestId));
			RepoTradeSubmissionResponse sellerRequest = executionAPI.postExecutionRequest(
					xApiRequestId,
					Constants.xParticipantId, 
					sellerName,
					Constants.xApiKey, 
					xSimulationDate, 
					trade);
			System.out.println(String.format("Trade submitted for the seller. Response: %s", sellerRequest));
		}
		
		{
			UUID xApiRequestId = UUID.randomUUID();
			System.out.println(String.format("Submitting trade to Trade Matching service for [%s] as-of [%s]. Request id: [%s].", buyerName, xSimulationDate, xApiRequestId));

			RepoTradeSubmissionResponse buyerRequest = executionAPI.postExecutionRequest(
					xApiRequestId,
					Constants.xParticipantId, 
					buyerName, 
					Constants.xApiKey, 
					xSimulationDate,
					trade);

			System.out.println(String.format("Trade submitted for the buyer. Response: %s", buyerRequest));
		}
	}
	
	private boolean tradeIsMatched(RepoTradeExecutionSubmissionRequest trade) throws Exception {

		UUID xApiRequestId = UUID.randomUUID();
        String xFinancialMemberId = trade.getSeller().getSellerName();
        String tradeId = trade.getTradeId();

        System.out.println("Checking trade matching status for trade: " + tradeId);
        
        TradeWorkflowStatusResponse response = queryAPI.getWorkflowEvents(
        		xApiRequestId, 
        		Constants.xParticipantId, 
        		xFinancialMemberId, 
        		Constants.xApiKey,
        		tradeId, 
        		"TRADE_MATCHING_SERVICE");
        List<WorkflowEventData> workflowEvents = response.getTradeSettlementService();
        if (workflowEvents.size()==1 && workflowEvents.get(0).getWorkflowEvents().size()==2) {
        	WorkflowEvent workflowEvent = workflowEvents.get(0).getWorkflowEvents().get(1);
        	String tradeStatus = workflowEvent.getTradeStatus();
        	String tradeMatchingStatus = workflowEvent.getTradeMatchingStatus();

            System.out.println("Trade matching status: " + tradeMatchingStatus);
            return ("TRADE_MATCH_SUCCESS".equals(tradeMatchingStatus));
        } else {
        	System.out.println("Unknown trade matching status");
            return false;
        }
	}
	
	private TradeBusinessEventsQueryResponse getTradeFormationEventFromTradeMatchingService(RepoTradeExecutionSubmissionRequest trade) {
		
		System.out.println("Getting trade formation event for trade: " + trade.getTradeId());
        
        String xFinancialMemberId = trade.getSeller().getSellerName();
        String xSimulationDate = trade.getTradeDetails().getTradeDate();
        
        TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = new TradeBusinessEventsQueryRequest();
        tradeBusinessEventsQueryRequest.setTradeId(trade.getTradeId());
        tradeBusinessEventsQueryRequest.setFmi("TRADE_MATCHING_SERVICE");
        tradeBusinessEventsQueryRequest.fromDate(OffsetDateTime.of(2023, 9, 25, 11, 51, 0, 0, ZoneOffset.UTC)); // Large enough to get all the data - needs proper filtering in real-world scenario 
        tradeBusinessEventsQueryRequest.toDate(OffsetDateTime.of(2023, 11, 15, 11, 52, 0, 0, ZoneOffset.UTC));

        UUID xApiRequestId = UUID.randomUUID();

        TradeBusinessEventsQueryResponse tradeBusinessEvents = queryAPI.getBusinessEvents(
            		xApiRequestId, 
            		Constants.xParticipantId, 
            		xFinancialMemberId, 
            		Constants.xApiKey, 
            		tradeBusinessEventsQueryRequest, 
            		xSimulationDate);
        System.out.println(tradeBusinessEvents);
        return tradeBusinessEvents;
	}
	
	private void updateTradeHashInHederaForNewContract(TradeBusinessEventsQueryResponse contractFormedEvent) throws Exception {
		BusinessEventData businessEventData = contractFormedEvent.getTradeMatchingService().get(0);
		BusinessEventDto businessEventDto = businessEventData.getBusinessEvents().get(0);

		ObjectMapper rosettaObjectMapper = RosettaObjectMapper.getNewRosettaObjectMapper();
		BusinessEvent businessEvent = rosettaObjectMapper.convertValue(businessEventDto.getBusinessEventData(), BusinessEvent.class);
		
		TradeState tradeState = businessEvent.getAfter().get(0);
		TradableProduct tradableProduct = tradeState.getTrade().getTradableProduct();
		String seller = tradableProduct.getCounterparty().get(1).getPartyReference().getValue().getName().getValue();
		String buyer = tradableProduct.getCounterparty().get(0).getPartyReference().getValue().getName().getValue();
		String cdmRef = businessEvent.getMeta().getGlobalKey();
		String tradeId = businessEventData.getTradeId();
		EconomicTerms economicTerms = tradableProduct.getProduct().getContractualProduct().getEconomicTerms();
		String tradeDate = economicTerms.getEffectiveDate().getAdjustableDate().getUnadjustedDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		System.out.println("Updating smart contract for trade: " + tradeId);
		hedera.updateTradeMatching(
				seller, // role, for demo purposes we assume to be the seller (repo trade)
	            tradeId, // tradeId
	            buyer, // cpty, for demo purposes they're the buyers (reverse repo from their perspective)
	            tradeDate, // Event date
	            businessEventDto.getBusinessEventName(), // EventType
	            cdmRef, // cdmHash, will be generated later
	            "" // lineageHashnull, will be generated later for settlement events
				);
		System.out.println(String.format("Smart contract update for trade [%s] with CDM hash [%s]", tradeId, cdmRef)); 
	}
	
	private void settleStartLegInHedera(RepoTradeExecutionSubmissionRequest trade, TradeBusinessEventsQueryResponse contractFormedEvent) throws Exception {
		
		BusinessEventData businessEventData = contractFormedEvent.getTradeMatchingService().get(0);
		BusinessEventDto businessEventDto = businessEventData.getBusinessEvents().get(0);

		ObjectMapper rosettaObjectMapper = RosettaObjectMapper.getNewRosettaObjectMapper();
		BusinessEvent businessEvent = rosettaObjectMapper.convertValue(businessEventDto.getBusinessEventData(), BusinessEvent.class);
		
		TradeState tradeState = businessEvent.getAfter().get(0);
		TradableProduct tradableProduct = tradeState.getTrade().getTradableProduct();
		String seller = tradableProduct.getCounterparty().get(1).getPartyReference().getValue().getName().getValue();
		String buyer = tradableProduct.getCounterparty().get(0).getPartyReference().getValue().getName().getValue();
		String cdmRef = businessEvent.getMeta().getGlobalKey();
		String tradeId = businessEventData.getTradeId();
		EconomicTerms economicTerms = tradableProduct.getProduct().getContractualProduct().getEconomicTerms();
		String tradeDate = economicTerms.getEffectiveDate().getAdjustableDate().getUnadjustedDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		System.out.println("Settling smart contract for trade: " + trade.getTradeId());
		hedera.updateSettlementEvent(
				tradeDate, // dvpDate,
				"123.456", // collateral, 
				economicTerms.getPayout().getInterestRatePayout().get(0).getRateSpecification().getFixedRate().getRateSchedule().getPrice().getValue().getValue().toString() // amount
				);
		System.out.println(String.format("Smart contract settled for trade [%s] with CDM hash [%s]", tradeId, cdmRef)); 
	}
	

	private void settleStartLegInSettlementSystem(TradeBusinessEventsQueryResponse contractFormationEvent) {

		BusinessEventData businessEventData = contractFormationEvent.getTradeMatchingService().get(0);
		BusinessEventDto businessEventDto = businessEventData.getBusinessEvents().get(0);

		ObjectMapper rosettaObjectMapper = RosettaObjectMapper.getNewRosettaObjectMapper();
		BusinessEvent businessEvent = rosettaObjectMapper.convertValue(businessEventDto.getBusinessEventData(), BusinessEvent.class);

		TradeState tradeState = businessEvent.getAfter().get(0);
		TradableProduct tradableProduct = tradeState.getTrade().getTradableProduct();

		String tradeId = businessEventData.getTradeId();
		String seller = tradableProduct.getCounterparty().get(1).getPartyReference().getValue().getName().getValue();
		String buyer = tradableProduct.getCounterparty().get(0).getPartyReference().getValue().getName().getValue();

		EconomicTerms economicTerms = tradableProduct.getProduct().getContractualProduct().getEconomicTerms();
		String tradeDate = economicTerms.getEffectiveDate().getAdjustableDate().getUnadjustedDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String cdmRef = businessEvent.getMeta().getGlobalKey();

		UUID xApiRequestId = UUID.randomUUID();
		String xSimulationDate = tradeDate;

		SettlementRequestBody settlementRequest = new SettlementRequestBody();
		settlementRequest.businessEventData(businessEventData);

		System.out.println(String.format("Instructing the Settlement Service for the start leg of trade [%], seller side.", tradeId));
		RepoTradeSubmissionResponse sellerResponse = settlementAPI.postSettlementRequest(
				xApiRequestId,
				Constants.xParticipantId, 
				seller, 
				Constants.xApiKey, 
				xSimulationDate, 
				settlementRequest);
		
		System.out.println(String.format("Instructing the Settlement Service for the start leg of trade [%], buyer side.", tradeId));
		RepoTradeSubmissionResponse buyerResponse = settlementAPI.postSettlementRequest(
				xApiRequestId,
				Constants.xParticipantId, 
				buyer, 
				Constants.xApiKey, 
				xSimulationDate, 
				settlementRequest);
		
	}

	 private void updateTradeHashInHederaForSettlement() throws Exception {
		 // TODO
		 System.out.println(String.format("Updating lineage ref in DLT."));
	}
}
