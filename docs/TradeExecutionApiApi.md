# TradeExecutionApiApi

All URIs are relative to *https://repohack2023.nayaone.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**postExecutionRequest**](TradeExecutionApiApi.md#postExecutionRequest) | **POST** /repoTrades/execution | Submit trade execution request. |



## postExecutionRequest

> RepoTradeSubmissionResponse postExecutionRequest(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, repoTradeExecutionSubmissionRequest)

Submit trade execution request.

Submit the trade request to the matching service of the trade matching middleware. 

### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.TradeExecutionApiApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        TradeExecutionApiApi apiInstance = new TradeExecutionApiApi(defaultClient);
        UUID xApiRequestId = UUID.fromString("5e970526-6ebe-4d9f-bab5-9f05fa07dcfd"); // UUID | Unique request identifier for the request.
        String xParticipantId = "TEAM0XX"; // String | Unique team identifier provided to your team.
        String xFinancialMemberId = "CLIENT02"; // String | Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        String xSimulationDate = "2023-09-21"; // String | Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd).
        RepoTradeExecutionSubmissionRequest repoTradeExecutionSubmissionRequest = new RepoTradeExecutionSubmissionRequest(); // RepoTradeExecutionSubmissionRequest | Repo Trade Execution Request
        try {
            RepoTradeSubmissionResponse result = apiInstance.postExecutionRequest(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, repoTradeExecutionSubmissionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradeExecutionApiApi#postExecutionRequest");
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
| **xFinancialMemberId** | **String**| Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |
| **xSimulationDate** | **String**| Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). | |
| **repoTradeExecutionSubmissionRequest** | [**RepoTradeExecutionSubmissionRequest**](RepoTradeExecutionSubmissionRequest.md)| Repo Trade Execution Request | |

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

