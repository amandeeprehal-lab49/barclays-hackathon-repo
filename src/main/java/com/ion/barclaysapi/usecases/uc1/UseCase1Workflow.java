package com.ion.barclaysapi.usecases.uc1;

import java.util.UUID;

import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.model.TradeWorkflowStatusResponse;

public class UseCase1Workflow {
	
	
	public static void main(String[] args) {

//		//ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");
        defaultClient.setDebugging(true);
//        defaultClient.setDateFormat(DateFormat.)
        
        TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
        UUID xApiRequestId = UUID.randomUUID();
        String xFinancialMemberId = "CLIENT03";
        String tradeId = "UC1SE6TL418HF0";
        String fmi = "TRADE_MATCHING_SERVICE";
        
        try {
            TradeWorkflowStatusResponse response = apiInstance.getWorkflowEvents(
            		xApiRequestId, 
            		Constants.xParticipantId, 
            		xFinancialMemberId, 
            		Constants.xApiKey,
            		tradeId, 
            		fmi);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
}
