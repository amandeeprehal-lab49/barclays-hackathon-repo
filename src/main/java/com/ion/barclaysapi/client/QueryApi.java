package com.ion.barclaysapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ion.barclaysapi.client.api.StartHereApi;
import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.model.PingResponse;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryRequest;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryResponse;
import com.ion.barclaysapi.client.model.TradeWorkflowStatusResponse;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class QueryApi {

    public static void main(String[] args) {

        ApiClient defaultClient = new ApiClient();
        defaultClient.setDebugging(true);
        defaultClient.setBasePath("https://repohack2023.nayaone.com");


        TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
        UUID xApiRequestId = UUID.randomUUID();
        String xParticipantId = "TEAM016"; // String | Unique team id assigned to your team.
        String xApiKey = "TEAM016_pojpjkbhbUTFUF5r7646ghwjyef3ww5uwygfuy9094UUG9_016"; // String | API authorization key provided to your team.
        String xFinancialMemberId = "CLIENT01";
        String xSimulationDate = "2023-10-02";
        TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = new TradeBusinessEventsQueryRequest();
        tradeBusinessEventsQueryRequest.setTradeId("UC1GQN1435RKX0");//UC1GQN1435RKX0
        tradeBusinessEventsQueryRequest.setFmi("TRADE_MATCHING_SERVICE");
        OffsetDateTime start = OffsetDateTime.parse("2023-09-25T10:27:08.943Z");
        OffsetDateTime end = OffsetDateTime.parse("2023-09-29T10:27:08.943Z");
        tradeBusinessEventsQueryRequest.fromDate(start);
        tradeBusinessEventsQueryRequest.toDate(end);
        try {
            TradeBusinessEventsQueryResponse response1 = apiInstance.getBusinessEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeBusinessEventsQueryRequest, xSimulationDate);
            TradeWorkflowStatusResponse response2 = apiInstance.getWorkflowEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, "UC1GQN1435RKX0" ,"TRADE_MATCHING_SERVICE");
            System.out.println(response1);
            System.out.println(response2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}