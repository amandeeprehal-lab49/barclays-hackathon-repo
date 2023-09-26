package com.ion.barclaysapi.client.api;

import com.ion.barclaysapi.client.invoker.ApiClient;

import com.ion.barclaysapi.client.model.AccessDeniedResponse;
import com.ion.barclaysapi.client.model.BadRequestResponse;
import com.ion.barclaysapi.client.model.ErrorResponseBody;
import com.ion.barclaysapi.client.model.RepoTradeExecutionSubmissionRequest;
import com.ion.barclaysapi.client.model.RepoTradeSubmissionResponse;
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
public class TradeExecutionApiApi {
    private ApiClient apiClient;

    public TradeExecutionApiApi() {
        this(new ApiClient());
    }

    public TradeExecutionApiApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Submit trade execution request.
     * Submit the trade request to the matching service of the trade matching middleware. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param xSimulationDate Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). (required)
     * @param repoTradeExecutionSubmissionRequest Repo Trade Execution Request (required)
     * @return RepoTradeSubmissionResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RepoTradeSubmissionResponse postExecutionRequest(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String xSimulationDate, RepoTradeExecutionSubmissionRequest repoTradeExecutionSubmissionRequest) throws RestClientException {
        return postExecutionRequestWithHttpInfo(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, repoTradeExecutionSubmissionRequest).getBody();
    }

    /**
     * Submit trade execution request.
     * Submit the trade request to the matching service of the trade matching middleware. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param xSimulationDate Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). (required)
     * @param repoTradeExecutionSubmissionRequest Repo Trade Execution Request (required)
     * @return ResponseEntity&lt;RepoTradeSubmissionResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<RepoTradeSubmissionResponse> postExecutionRequestWithHttpInfo(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String xSimulationDate, RepoTradeExecutionSubmissionRequest repoTradeExecutionSubmissionRequest) throws RestClientException {
        Object localVarPostBody = repoTradeExecutionSubmissionRequest;
        
        // verify the required parameter 'xApiRequestId' is set
        if (xApiRequestId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiRequestId' when calling postExecutionRequest");
        }
        
        // verify the required parameter 'xParticipantId' is set
        if (xParticipantId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xParticipantId' when calling postExecutionRequest");
        }
        
        // verify the required parameter 'xFinancialMemberId' is set
        if (xFinancialMemberId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xFinancialMemberId' when calling postExecutionRequest");
        }
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiKey' when calling postExecutionRequest");
        }
        
        // verify the required parameter 'xSimulationDate' is set
        if (xSimulationDate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xSimulationDate' when calling postExecutionRequest");
        }
        
        // verify the required parameter 'repoTradeExecutionSubmissionRequest' is set
        if (repoTradeExecutionSubmissionRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'repoTradeExecutionSubmissionRequest' when calling postExecutionRequest");
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

        ParameterizedTypeReference<RepoTradeSubmissionResponse> localReturnType = new ParameterizedTypeReference<RepoTradeSubmissionResponse>() {};
        return apiClient.invokeAPI("/repoTrades/execution", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
