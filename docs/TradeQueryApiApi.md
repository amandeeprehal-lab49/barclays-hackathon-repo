# TradeQueryApiApi

All URIs are relative to *https://repohack2023.nayaone.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBusinessEvents**](TradeQueryApiApi.md#getBusinessEvents) | **POST** /repoTrades/tradeBusinessEventsQuery/ | Get trade business events. |
| [**getWorkflowEvents**](TradeQueryApiApi.md#getWorkflowEvents) | **GET** /repoTrades/tradeWorkflowStatus/ | Get trade workflow statuses. |



## getBusinessEvents

> TradeBusinessEventsQueryResponse getBusinessEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeBusinessEventsQueryRequest, xSimulationDate)

Get trade business events.

Get the trade business events processed at the FMIs.

### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.TradeQueryApiApi;
import com.ion.barclaysapi.client.invoker.Configuration;


public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
        UUID xApiRequestId = UUID.fromString("5e970526-6ebe-4d9f-bab5-9f05fa07dcfd"); // UUID | Unique request identifier for the request.
        String xParticipantId = "TEAM0XX"; // String | Unique team identifier provided to your team.
        String xFinancialMemberId = "DEALER01"; // String | Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = new TradeBusinessEventsQueryRequest(); // TradeBusinessEventsQueryRequest | 
        String xSimulationDate = "2023-09-21"; // String | Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd).
        try {
            TradeBusinessEventsQueryResponse result = apiInstance.getBusinessEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeBusinessEventsQueryRequest, xSimulationDate);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradeQueryApiApi#getBusinessEvents");
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
| **xFinancialMemberId** | **String**| Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |
| **tradeBusinessEventsQueryRequest** | [**TradeBusinessEventsQueryRequest**](TradeBusinessEventsQueryRequest.md)|  | |
| **xSimulationDate** | **String**| Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd). | [optional] |

### Return type

[**TradeBusinessEventsQueryResponse**](TradeBusinessEventsQueryResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved trade business events |  -  |
| **400** | Bad/Invalid request. |  -  |
| **404** | Resource not found. |  -  |
| **403** | Access Denied to API. |  -  |
| **500** | Internal Server Error. |  -  |


## getWorkflowEvents

> TradeWorkflowStatusResponse getWorkflowEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeId, fmi)

Get trade workflow statuses.

Get workflow statuses of the trades processed at the FMIs.

### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.TradeQueryApiApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        TradeQueryApiApi apiInstance = new TradeQueryApiApi(defaultClient);
        UUID xApiRequestId = UUID.fromString("5e970526-6ebe-4d9f-bab5-9f05fa07dcfd"); // UUID | Unique request identifier for the request.
        String xParticipantId = "TEAM0XX"; // String | Unique team identifier provided to your team.
        String xFinancialMemberId = "CLIENT02"; // String | Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        String tradeId = "UC2Q0EKXFH6260"; // String | Unique identifier for the trade.
        String fmi = "TRADE_MATCHING_SERVICE"; // String | Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE
        try {
            TradeWorkflowStatusResponse result = apiInstance.getWorkflowEvents(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeId, fmi);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TradeQueryApiApi#getWorkflowEvents");
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
| **xFinancialMemberId** | **String**| Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |
| **tradeId** | **String**| Unique identifier for the trade. | [optional] |
| **fmi** | **String**| Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE | [optional] |

### Return type

[**TradeWorkflowStatusResponse**](TradeWorkflowStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved trade workflow statuses |  -  |
| **400** | Bad/Invalid request. |  -  |
| **404** | Resource not found. |  -  |
| **403** | Access Denied to API. |  -  |
| **500** | Internal Server Error. |  -  |

