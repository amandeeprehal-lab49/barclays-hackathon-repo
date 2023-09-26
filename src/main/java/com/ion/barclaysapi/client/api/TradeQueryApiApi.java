package com.ion.barclaysapi.client.api;

import com.ion.barclaysapi.client.invoker.ApiClient;

import com.ion.barclaysapi.client.model.AccessDeniedResponse;
import com.ion.barclaysapi.client.model.BadRequestResponse;
import com.ion.barclaysapi.client.model.ErrorResponseBody;
import com.ion.barclaysapi.client.model.NotFoundResponse;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryRequest;
import com.ion.barclaysapi.client.model.TradeBusinessEventsQueryResponse;
import com.ion.barclaysapi.client.model.TradeWorkflowStatusResponse;
import java.util.UUID;

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
public class TradeQueryApiApi {
    private ApiClient apiClient;

    public TradeQueryApiApi() {
        this(new ApiClient());
    }

    public TradeQueryApiApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get trade business events.
     * Get the trade business events processed at the FMIs.
     * <p><b>200</b> - Successfully retrieved trade business events
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>404</b> - Resource not found.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param tradeBusinessEventsQueryRequest  (required)
     * @param xSimulationDate Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd). (optional)
     * @return TradeBusinessEventsQueryResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TradeBusinessEventsQueryResponse getBusinessEvents(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest, String xSimulationDate) throws RestClientException {
        return getBusinessEventsWithHttpInfo(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeBusinessEventsQueryRequest, xSimulationDate).getBody();
    }

    /**
     * Get trade business events.
     * Get the trade business events processed at the FMIs.
     * <p><b>200</b> - Successfully retrieved trade business events
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>404</b> - Resource not found.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param tradeBusinessEventsQueryRequest  (required)
     * @param xSimulationDate Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd). (optional)
     * @return ResponseEntity&lt;TradeBusinessEventsQueryResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TradeBusinessEventsQueryResponse> getBusinessEventsWithHttpInfo(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest, String xSimulationDate) throws RestClientException {
        Object localVarPostBody = tradeBusinessEventsQueryRequest;
        
        // verify the required parameter 'xApiRequestId' is set
        if (xApiRequestId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiRequestId' when calling getBusinessEvents");
        }
        
        // verify the required parameter 'xParticipantId' is set
        if (xParticipantId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xParticipantId' when calling getBusinessEvents");
        }
        
        // verify the required parameter 'xFinancialMemberId' is set
        if (xFinancialMemberId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xFinancialMemberId' when calling getBusinessEvents");
        }
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiKey' when calling getBusinessEvents");
        }
        
        // verify the required parameter 'tradeBusinessEventsQueryRequest' is set
        if (tradeBusinessEventsQueryRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tradeBusinessEventsQueryRequest' when calling getBusinessEvents");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (xApiRequestId != null)
        localVarHeaderParams.add("x-api-request-id", apiClient.parameterToString(xApiRequestId));
        if (xParticipantId != null)
        localVarHeaderParams.add("x-participant-id", apiClient.parameterToString(xParticipantId));
        if (xFinancialMemberId != null)
        localVarHeaderParams.add("x-financial-member-id", apiClient.parameterToString(xFinancialMemberId));
        if (xApiKey != null)
        localVarHeaderParams.add("x-api-key", apiClient.parameterToString(xApiKey));
        if (xSimulationDate != null)
        localVarHeaderParams.add("x-simulation-date", apiClient.parameterToString(xSimulationDate));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TradeBusinessEventsQueryResponse> localReturnType = new ParameterizedTypeReference<TradeBusinessEventsQueryResponse>() {};
        return apiClient.invokeAPI("/repoTrades/tradeBusinessEventsQuery/", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get trade workflow statuses.
     * Get workflow statuses of the trades processed at the FMIs.
     * <p><b>200</b> - Successfully retrieved trade workflow statuses
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>404</b> - Resource not found.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param tradeId Unique identifier for the trade. (optional)
     * @param fmi Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE (optional)
     * @return TradeWorkflowStatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TradeWorkflowStatusResponse getWorkflowEvents(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String tradeId, String fmi) throws RestClientException {
        return getWorkflowEventsWithHttpInfo(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, tradeId, fmi).getBody();
    }

    /**
     * Get trade workflow statuses.
     * Get workflow statuses of the trades processed at the FMIs.
     * <p><b>200</b> - Successfully retrieved trade workflow statuses
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>404</b> - Resource not found.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param tradeId Unique identifier for the trade. (optional)
     * @param fmi Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE (optional)
     * @return ResponseEntity&lt;TradeWorkflowStatusResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TradeWorkflowStatusResponse> getWorkflowEventsWithHttpInfo(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String tradeId, String fmi) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'xApiRequestId' is set
        if (xApiRequestId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiRequestId' when calling getWorkflowEvents");
        }
        
        // verify the required parameter 'xParticipantId' is set
        if (xParticipantId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xParticipantId' when calling getWorkflowEvents");
        }
        
        // verify the required parameter 'xFinancialMemberId' is set
        if (xFinancialMemberId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xFinancialMemberId' when calling getWorkflowEvents");
        }
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiKey' when calling getWorkflowEvents");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tradeId", tradeId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "fmi", fmi));


        if (xApiRequestId != null)
        localVarHeaderParams.add("x-api-request-id", apiClient.parameterToString(xApiRequestId));
        if (xParticipantId != null)
        localVarHeaderParams.add("x-participant-id", apiClient.parameterToString(xParticipantId));
        if (xFinancialMemberId != null)
        localVarHeaderParams.add("x-financial-member-id", apiClient.parameterToString(xFinancialMemberId));
        if (xApiKey != null)
        localVarHeaderParams.add("x-api-key", apiClient.parameterToString(xApiKey));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TradeWorkflowStatusResponse> localReturnType = new ParameterizedTypeReference<TradeWorkflowStatusResponse>() {};
        return apiClient.invokeAPI("/repoTrades/tradeWorkflowStatus/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
