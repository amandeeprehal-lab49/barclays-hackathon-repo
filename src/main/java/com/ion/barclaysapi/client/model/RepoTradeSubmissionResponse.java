/*
 * Barclays RepoHack 2023 API
 * APIs for the dealers’ and clients’ interactions with financial market infrastructure services (Trade matching middleware, CCPs, CSDs) for the Barclays 2023 Repo Hackathon.<br>Please ensure you include your API key in the `x-api-key` header of your requests.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ion.barclaysapi.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * RepoTradeSubmissionResponse
 */
@JsonPropertyOrder({
  RepoTradeSubmissionResponse.JSON_PROPERTY_TRADE_ID,
  RepoTradeSubmissionResponse.JSON_PROPERTY_TRADE_STATUS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-25T22:42:46.793138+05:30[Asia/Kolkata]")
public class RepoTradeSubmissionResponse {
  public static final String JSON_PROPERTY_TRADE_ID = "tradeId";
  private String tradeId;

  public static final String JSON_PROPERTY_TRADE_STATUS = "tradeStatus";
  private String tradeStatus;

  public RepoTradeSubmissionResponse() {
  }

  public RepoTradeSubmissionResponse tradeId(String tradeId) {
    
    this.tradeId = tradeId;
    return this;
  }

   /**
   * Get tradeId
   * @return tradeId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRADE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTradeId() {
    return tradeId;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }


  public RepoTradeSubmissionResponse tradeStatus(String tradeStatus) {
    
    this.tradeStatus = tradeStatus;
    return this;
  }

   /**
   * Get tradeStatus
   * @return tradeStatus
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRADE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTradeStatus() {
    return tradeStatus;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTradeStatus(String tradeStatus) {
    this.tradeStatus = tradeStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeSubmissionResponse repoTradeSubmissionResponse = (RepoTradeSubmissionResponse) o;
    return Objects.equals(this.tradeId, repoTradeSubmissionResponse.tradeId) &&
        Objects.equals(this.tradeStatus, repoTradeSubmissionResponse.tradeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, tradeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeSubmissionResponse {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    tradeStatus: ").append(toIndentedString(tradeStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

