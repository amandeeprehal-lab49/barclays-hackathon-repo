import com.ion.barclaysapi.client.invoker.*;
import com.ion.barclaysapi.client.invoker.auth.*;
import com.ion.barclaysapi.client.model.*;
import com.ion.barclaysapi.client.api.StartHereApi;


public class StartHereApiExample {

    public static void main(String[] args) {
        //ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        StartHereApi apiInstance = new StartHereApi(defaultClient);
        String xParticipantId = "TEAM0XX"; // String | Unique team id assigned to your team.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
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