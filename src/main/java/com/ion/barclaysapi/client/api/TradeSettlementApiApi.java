package com.ion.barclaysapi.client.api;

import com.ion.barclaysapi.client.invoker.ApiClient;

import com.ion.barclaysapi.client.model.AccessDeniedResponse;
import com.ion.barclaysapi.client.model.BadRequestResponse;
import com.ion.barclaysapi.client.model.ErrorResponseBody;
import com.ion.barclaysapi.client.model.RepoTradeSubmissionResponse;
import com.ion.barclaysapi.client.model.SettlementRequestBody;
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
public class TradeSettlementApiApi {
    private ApiClient apiClient;

    public TradeSettlementApiApi() {
        this(new ApiClient());
    }

    public TradeSettlementApiApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Submit trade settlement request.
     * Submit the trade request to the CSD&#39;s settlement service. &lt;br&gt;&lt;br&gt; Input to this API is a contract formation business event in CDM format. For UC1, it is the business event returned by the trade matching middleware service. For UC2 it is the business events returned by the clearing service. &lt;br&gt;&lt;br&gt; You can use the Rosetta Technology Portal to understand the specification of a business event.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param xSimulationDate Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). (required)
     * @param settlementRequestBody  (required)
     * @return RepoTradeSubmissionResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RepoTradeSubmissionResponse postSettlementRequest(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String xSimulationDate, SettlementRequestBody settlementRequestBody) throws RestClientException {
        return postSettlementRequestWithHttpInfo(xApiRequestId, xParticipantId, xFinancialMemberId, xApiKey, xSimulationDate, settlementRequestBody).getBody();
    }

    /**
     * Submit trade settlement request.
     * Submit the trade request to the CSD&#39;s settlement service. &lt;br&gt;&lt;br&gt; Input to this API is a contract formation business event in CDM format. For UC1, it is the business event returned by the trade matching middleware service. For UC2 it is the business events returned by the clearing service. &lt;br&gt;&lt;br&gt; You can use the Rosetta Technology Portal to understand the specification of a business event.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad/Invalid request.
     * <p><b>403</b> - Access Denied to API.
     * <p><b>500</b> - Internal Server Error.
     * @param xApiRequestId Unique request identifier for the request. (required)
     * @param xParticipantId Unique team identifier provided to your team. (required)
     * @param xFinancialMemberId Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades. (required)
     * @param xApiKey API authorization key provided to your team. (required)
     * @param xSimulationDate Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd). (required)
     * @param settlementRequestBody  (required)
     * @return ResponseEntity&lt;RepoTradeSubmissionResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequestWithHttpInfo(UUID xApiRequestId, String xParticipantId, String xFinancialMemberId, String xApiKey, String xSimulationDate, SettlementRequestBody settlementRequestBody) throws RestClientException {
        Object localVarPostBody = settlementRequestBody;
        
        // verify the required parameter 'xApiRequestId' is set
        if (xApiRequestId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiRequestId' when calling postSettlementRequest");
        }
        
        // verify the required parameter 'xParticipantId' is set
        if (xParticipantId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xParticipantId' when calling postSettlementRequest");
        }
        
        // verify the required parameter 'xFinancialMemberId' is set
        if (xFinancialMemberId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xFinancialMemberId' when calling postSettlementRequest");
        }
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xApiKey' when calling postSettlementRequest");
        }
        
        // verify the required parameter 'xSimulationDate' is set
        if (xSimulationDate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xSimulationDate' when calling postSettlementRequest");
        }
        
        // verify the required parameter 'settlementRequestBody' is set
        if (settlementRequestBody == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'settlementRequestBody' when calling postSettlementRequest");
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
        return apiClient.invokeAPI("/repoTrades/settlement", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
