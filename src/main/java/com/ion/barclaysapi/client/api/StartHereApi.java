package com.ion.barclaysapi.client.api;

import com.ion.barclaysapi.client.invoker.ApiClient;

import com.ion.barclaysapi.client.model.PingResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-25T22:42:46.793138+05:30[Asia/Kolkata]")
public class StartHereApi {
    private ApiClient apiClient;

    public StartHereApi() {
        this(new ApiClient());
    }

    public StartHereApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param xParticipantId Unique team id assigned to your team. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @return PingResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PingResponse getAuthPing(String xParticipantId, String xApiKey) throws RestClientException {
        return getAuthPingWithHttpInfo(xParticipantId, xApiKey).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param xParticipantId Unique team id assigned to your team. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @return ResponseEntity&lt;PingResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PingResponse> getAuthPingWithHttpInfo(String xParticipantId, String xApiKey) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'xParticipantId' is set
        if (xParticipantId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xParticipantId' when calling getAuthPing");
        }
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiKey' when calling getAuthPing");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (xParticipantId != null)
        localVarHeaderParams.add("x-participant-id", apiClient.parameterToString(xParticipantId));
        if (xApiKey != null)
        localVarHeaderParams.add("x-api-key", apiClient.parameterToString(xApiKey));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PingResponse> localReturnType = new ParameterizedTypeReference<PingResponse>() {};
        return apiClient.invokeAPI("/start-here/auth-ping", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return PingResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PingResponse getPublicPing() throws RestClientException {
        return getPublicPingWithHttpInfo().getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;PingResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PingResponse> getPublicPingWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PingResponse> localReturnType = new ParameterizedTypeReference<PingResponse>() {};
        return apiClient.invokeAPI("/start-here/public-ping", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
