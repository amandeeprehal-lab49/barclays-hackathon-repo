package com.ion.barclaysapi.usecases.uc1;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryRequest;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryResponse;

public class UseCase1BusinessEvents {

    public static void main(String[] args) {

    	//ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");
        defaultClient.setDebugging(true);
//        defaultClient.setDateFormat(DateFormat.)
        
        TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
        UUID xApiRequestId = UUID.randomUUID();
        String xFinancialMemberId = "CLIENT01";
        String xSimulationDate = "2023-10-02";
        TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = new TradeBusinessEventsQueryRequest();
        tradeBusinessEventsQueryRequest.setTradeId("UC1GQN1435RKX0");//UC1GQN1435RKX0
        tradeBusinessEventsQueryRequest.setFmi("TRADE_MATCHING_SERVICE");
        tradeBusinessEventsQueryRequest.fromDate(OffsetDateTime.of(2023, 9, 25, 11, 51, 0, 0, ZoneOffset.UTC));
        tradeBusinessEventsQueryRequest.toDate(OffsetDateTime.of(2023, 10, 29, 11, 52, 0, 0, ZoneOffset.UTC));
        try {
            TradeBusinessEventsQueryResponse response = apiInstance.getBusinessEvents(
            		xApiRequestId, 
            		Constants.xParticipantId, 
            		xFinancialMemberId, 
            		Constants.xApiKey, 
            		tradeBusinessEventsQueryRequest, 
            		xSimulationDate);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}