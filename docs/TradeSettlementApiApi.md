# TradeSettlementApiApi

All URIs are relative to *https://repohack2023.nayaone.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**postSettlementRequest**](TradeSettlementApiApi.md#postSettlementRequest) | **POST** /repoTrades/settlement | Submit trade settlement request. |



## postSettlementRequest

> RepoTradeSubmissionResponse postSettlementRequest(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, settlementRequestBody)

Submit trade settlement request.

Submit the trade request to the CSD&#39;s settlement service. &lt;br&gt;&lt;br&gt; Input to this API is a contract formation business event in CDM format. For UC1, it is the business event returned by the trade matching middleware service. For UC2 it is the business events returned by the clearing service. &lt;br&gt;&lt;br&gt; You can use the Rosetta Technology Portal to understand the specification of a business event.

### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.TradeSettlementApiApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        TradeSettlementApiApi apiInstance = new TradeSettlementApiApi(defaultClient);
        UUID xApiRequestId = UUID.fromString("5e970526-6ebe-4d9f-bab5-9f05fa07dcfd"); // UUID | Unique request identifier for the request.
        String xParticipantId = "TEAM0XX"; // String | Unique team identifier provided to your team.
        String xFinancialMemberId = "DEALER01"; // String | Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        String xSimulationDate = "2023-09-21"; // String | Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd).
        SettlementRequestBody settlementRequestBody = new SettlementRequestBody(); // SettlementRequestBody | 
        try {
            RepoTradeSubmissionResponse result = apiInstance.postSettlementRequest(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, settlementRequestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradeSettlementApiApi#postSettlementRequest");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xApiRequestId** | **UUID**| Unique request identifier for the request. | |
| **xParticipantId** | **String**| Unique team identifier provided to your team. | |
| **xFinancialMemberId** | **String**| Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |
| **xSimulationDate** | **String**| Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). | |
| **settlementRequestBody** | [**SettlementRequestBody**](SettlementRequestBody.md)|  | |

### Return type

[**RepoTradeSubmissionResponse**](RepoTradeSubmissionResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad/Invalid request. |  -  |
| **403** | Access Denied to API. |  -  |
| **500** | Internal Server Error. |  -  |

