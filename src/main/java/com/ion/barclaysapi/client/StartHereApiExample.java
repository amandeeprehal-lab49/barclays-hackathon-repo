package com.ion.barclaysapi.client;

import com.ion.barclaysapi.client.invoker.*;
import com.ion.barclaysapi.client.invoker.auth.*;
import com.ion.barclaysapi.client.model.*;
import com.ion.barclaysapi.client.api.StartHereApi;


public class StartHereApiExample {

	private static final String TEAM_ID = "TEAM016";
    private static final String TEAM_API_KEY = "TEAM016_pojpjkbhbUTFUF5r7646ghwjyef3ww5uwygfuy9094UUG9_016";

	public static void main(String[] args) {
        //ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        StartHereApi apiInstance = new StartHereApi(defaultClient);
        String xParticipantId = TEAM_ID; // String | Unique team id assigned to your team.
        String xApiKey = TEAM_API_KEY; // String | API authorization key provided to your team.
        try {
            PingResponse result = apiInstance.getAuthPing(xParticipantId, xApiKey);
            System.out.println(result);
        } catch (Exception e) {
//            System.err.println("Exception when calling StartHereApi#getAuthPing");
//            System.err.println("Status code: " + e.getCode());
//            System.err.println("Reason: " + e.getResponseBody());
//            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}