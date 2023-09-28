package com.ion.barclaysapi.usecases.uc1;

import java.io.File;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ion.barclaysapi.client.api.TradeExecutionApiApi;
import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.api.TradeSettlementApiApi;
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.model.RepoTradeExecutionSubmissionRequest;
import com.ion.barclaysapi.client.model.RepoTradeSubmissionResponse;
import com.ion.barclaysapi.client.model.TradeWorkflowStatusResponse;
import com.ion.barclaysapi.hedera.HederaFunctions;

public class UseCase4Orchestrator {
	public static void main(String[] args) {

//		String inputFolder = System.getProperty("repohack2023.uc1.input_dir");
		String inputFolder = "C:\\Users\\dlevantesi\\RepoHack2023\\RepoHack2023_Files\\new_trades";
		new UseCase1TradeExecution().processAllInputFiles(new File(inputFolder));
		
	}

	
	public void demo(File tradeJson) throws Exception {
		
		
		RepoTradeExecutionSubmissionRequest trade = newTradeAgreed();
		
		// Simulate new trade agreed in DLT
		submitTradeToDLT(trade);
		
		// Simulate to have received an event from the DLT, saying that a new contract has been formed. 
		submitTradeToMatchingService(trade);
		
		if (tradeIsMatched(trade)) {
		
			// We automatically simulate that the trade is settled in DLT.
			// We can't settle directly in DLT at the moment, so this orchestrator will automatically settle in DLT.
			var businessEvent = getTradeFormationBusinessEventFromBarclays(trade);
			
			// This is for the sake of the demo - we can't generate the hash in DLT at the moment, so we delegate to Barclays's API to do it for us.
			updateTradeHashInHedera(businessEvent);
							
			if (settleTradeStartLegInHedera(businessEvent)) {
				
				// Settlement occurs in DLT - we synch Barclays's status
				var settlementEvent1 = settleTradeStartLegInBarclays(businessEvent, buyer);
				var settlementEvent2 = settleTradeStartLegInBarclays(businessEvent, seller);
				updateTradeHashInHedera(settlementEvent1);
				updateTradeHashInHedera(settlementEvent2);
				
			
				if (settleTradeEndLegInHedera(businessEvent)) {
					settleTradeEndtLegInBarclays(businessEvent, buyer);
					settleTradeEndLegInBarclays(businessEvent, seller);
				}
			}
		}
	}

	




	private TradeExecutionApiApi executionAPI ;
	private TradeQueryApiApi queryAPI;
	private TradeSettlementApiApi settlementAPI;
	private HederaFunctions hedera;
	
	

	public UseCase4Orchestrator() {
			this.executionAPI = new TradeExecutionApiApi(newAPIClient());
			this.queryAPI = new TradeQueryApiApi(newAPIClient());
			this.settlementAPI = new TradeSettlementApiApi(newAPIClient());
			this.hedera = new HederaFunctions()
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
			System.out.println(String.format("Submitting trade to Trade Matching servicefor [%s] as-of [%s]. Request id: [%s].", sellerName, xSimulationDate, xApiRequestId2));
			UUID xApiRequestId = UUID.randomUUID();
			RepoTradeSubmissionResponse sellerRequest2 = executionAPI.postExecutionRequest(
					xApiRequestId,
					Constants.xParticipantId, 
					sellerName,
					Constants.xApiKey, 
					xSimulationDate, 
					trade);
			System.out.println(String.format("Trade submitted for the seller. Response: %s", buyerRequest));
		}
		
		{
			UUID xApiRequestId = UUID.randomUUID();

			System.out.println(String.format("Submitting trade to Trade Matching service for [%s] as-of [%s]. Request id: [%s].", buyerName, xSimulationDate, xApiRequestId1));

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

        System.out.println("Checking trade matching status for trade: %s" + tradeId);
        
        TradeWorkflowStatusResponse response = queryAPI.getWorkflowEvents(
        		xApiRequestId, 
        		Constants.xParticipantId, 
        		xFinancialMemberId, 
        		Constants.xApiKey,
        		tradeId, 
        		"TRADE_MATCHING_SERVICE");
        response.getTradeMatchingService().
        System.out.println(response);
	}
//	
//	
//	
//	
//	
//	
//	
//	
//	private TradeExecutionApiApi executionAPI ;
//	
//	public UseCase1TradeExecution() {
//		this.executionAPI = new TradeExecutionApiApi();
//
//	}
//	
//	public void processAllInputFiles(final File folder) {
//		for (final File inputFile : folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json.SUCCESS"))) {
//			processFile(inputFile);
//		}
//	}
//
//	private void processFile(File inputFile) {
//		try {
//			
//			System.out.println("Processing input file: " + inputFile.getName());
//
//			ObjectMapper objectMapper = new ObjectMapper();
//			RepoTradeExecutionSubmissionRequest repoTrade = objectMapper.readValue(inputFile, RepoTradeExecutionSubmissionRequest.class);
//
//			String tradeId = repoTrade.getTradeId();
//			String buyerName = repoTrade.getBuyer().getBuyerName();
//			String sellerName = repoTrade.getSeller().getSellerName();
//			String tradeDate = repoTrade.getTradeDetails().getTradeDate();
//			String maturityDate = repoTrade.getTradeDetails().getMaturityDate();
//
////			getBusinessEvent("TRADE_SETTLsellerName, tradeDate, tradeId, maturityDate);
//
//		} catch (Exception e) {
//			System.err.println("Exception when calling StartHereApi#getPublicPing");
//			e.printStackTrace();
//		}
//	}
//	
//	void getBusinessEvent(String fmi, String role, String tradeId, String date) {
//		//ApiClient defaultClient = Configuration.getDefaultApiClient();
//	    ApiClient defaultClient = new ApiClient();
//	    defaultClient.setBasePath("https://repohack2023.nayaone.com");
//	    defaultClient.setDebugging(true);
//	    
//	    TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
//	    UUID xApiRequestId = UUID.randomUUID();
//	    String xFinancialMemberId = role;
//	    String xSimulationDate = date;
//
//	    TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = new TradeBusinessEventsQueryRequest();
//	    tradeBusinessEventsQueryRequest.setTradeId(tradeId);
//	    tradeBusinessEventsQueryRequest.setFmi(fmi);
//	    tradeBusinessEventsQueryRequest.fromDate(OffsetDateTime.parse(date));
//	    tradeBusinessEventsQueryRequest.toDate(OffsetDateTime.parse(date).plusDays(1));
//	    try {
//	        TradeBusinessEventsQueryResponse response = apiInstance.getBusinessEvents(
//	        		xApiRequestId, 
//	        		Constants.xParticipantId, 
//	        		xFinancialMemberId, 
//	        		Constants.xApiKey, 
//	        		tradeBusinessEventsQueryRequest, 
//	        		xSimulationDate);
//	        System.out.println(response);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
}
