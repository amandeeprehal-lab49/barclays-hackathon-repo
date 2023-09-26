# TradeClearingApiApi

All URIs are relative to *https://repohack2023.nayaone.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**postSettlementRequest1**](TradeClearingApiApi.md#postSettlementRequest1) | **POST** /repoTrades/clearing | Submit trade clearing request. |



## postSettlementRequest1

> RepoTradeSubmissionResponse postSettlementRequest1(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, clearingRequestBody)

Submit trade clearing request.

Submit the trade request to CCP&#39;s clearing service. &lt;br&gt;&lt;br&gt; Input to this API is a contract formation business event (in CDM format) received from the trade matching service. &lt;br&gt;&lt;br&gt; You can use the Rosetta Technology Portal to understand the specification of a business event

### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.TradeClearingApiApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        TradeClearingApiApi apiInstance = new TradeClearingApiApi(defaultClient);
        UUID xApiRequestId = UUID.fromString("5e970526-6ebe-4d9f-bab5-9f05fa07dcfd"); // UUID | Unique request identifier for the request.
        String xParticipantId = "TEAM0XX"; // String | Unique team identifier provided to your team.
        String xFinancialMemberId = "CLIENT02"; // String | Name of the party submitting the trade (should match with the value specified in the input business event data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        String xSimulationDate = "2023-09-21"; // String | Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd).
        ClearingRequestBody clearingRequestBody = new ClearingRequestBody(); // ClearingRequestBody | 
        try {
            RepoTradeSubmissionResponse result = apiInstance.postSettlementRequest1(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, clearingRequestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradeClearingApiApi#postSettlementRequest1");
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
| **xFinancialMemberId** | **String**| Name of the party submitting the trade (should match with the value specified in the input business event data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |
| **xSimulationDate** | **String**| Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). | |
| **clearingRequestBody** | [**ClearingRequestBody**](ClearingRequestBody.md)|  | |

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

