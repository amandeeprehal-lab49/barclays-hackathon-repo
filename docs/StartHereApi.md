# StartHereApi

All URIs are relative to *https://repohack2023.nayaone.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAuthPing**](StartHereApi.md#getAuthPing) | **GET** /start-here/auth-ping |  |
| [**getPublicPing**](StartHereApi.md#getPublicPing) | **GET** /start-here/public-ping |  |



## getAuthPing

> PingResponse getAuthPing(xParticipantId, xApiKey)



### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.StartHereApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        StartHereApi apiInstance = new StartHereApi(defaultClient);
        String xParticipantId = "TEAM0XX"; // String | Unique team id assigned to your team.
        String xApiKey = "TEAM0XX_ABCDCEFGHIJabcdefghij12345668438383_0XX"; // String | API authorization key provided to your team.
        try {
            PingResponse result = apiInstance.getAuthPing(xParticipantId, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling StartHereApi#getAuthPing");
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
| **xParticipantId** | **String**| Unique team id assigned to your team. | |
| **xApiKey** | **String**| API authorization key provided to your team. | |

### Return type

[**PingResponse**](PingResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getPublicPing

> PingResponse getPublicPing()



### Example

```java
// Import classes:
import com.ion.barclaysapi.client.invoker.ApiClient;
import com.ion.barclaysapi.client.invoker.ApiException;
import com.ion.barclaysapi.client.invoker.Configuration;
import com.ion.barclaysapi.client.invoker.models.*;
import com.ion.barclaysapi.client.api.StartHereApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://repohack2023.nayaone.com");

        StartHereApi apiInstance = new StartHereApi(defaultClient);
        try {
            PingResponse result = apiInstance.getPublicPing();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling StartHereApi#getPublicPing");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**PingResponse**](PingResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

