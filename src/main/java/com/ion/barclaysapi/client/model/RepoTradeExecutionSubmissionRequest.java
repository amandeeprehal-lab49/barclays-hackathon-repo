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
import com.ion.barclaysapi.client.model.RepoBuyer;
import com.ion.barclaysapi.client.model.RepoSeller;
import com.ion.barclaysapi.client.model.RepoTradeDetails;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * RepoTradeExecutionSubmissionRequest
 */
@JsonPropertyOrder({
  RepoTradeExecutionSubmissionRequest.JSON_PROPERTY_TRADE_ID,
  RepoTradeExecutionSubmissionRequest.JSON_PROPERTY_BUYER,
  RepoTradeExecutionSubmissionRequest.JSON_PROPERTY_SELLER,
  RepoTradeExecutionSubmissionRequest.JSON_PROPERTY_TRADE_DETAILS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-25T22:42:46.793138+05:30[Asia/Kolkata]")
public class RepoTradeExecutionSubmissionRequest {
  public static final String JSON_PROPERTY_TRADE_ID = "trade_id";
  private String tradeId;

  public static final String JSON_PROPERTY_BUYER = "buyer";
  private RepoBuyer buyer;

  public static final String JSON_PROPERTY_SELLER = "seller";
  private RepoSeller seller;

  public static final String JSON_PROPERTY_TRADE_DETAILS = "trade_details";
  private RepoTradeDetails tradeDetails;

  public RepoTradeExecutionSubmissionRequest() {
  }

  public RepoTradeExecutionSubmissionRequest tradeId(String tradeId) {
    
    this.tradeId = tradeId;
    return this;
  }

   /**
   * Get tradeId
   * @return tradeId
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRADE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTradeId() {
    return tradeId;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }


  public RepoTradeExecutionSubmissionRequest buyer(RepoBuyer buyer) {
    
    this.buyer = buyer;
    return this;
  }

   /**
   * Get buyer
   * @return buyer
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BUYER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RepoBuyer getBuyer() {
    return buyer;
  }


  @JsonProperty(JSON_PROPERTY_BUYER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBuyer(RepoBuyer buyer) {
    this.buyer = buyer;
  }


  public RepoTradeExecutionSubmissionRequest seller(RepoSeller seller) {
    
    this.seller = seller;
    return this;
  }

   /**
   * Get seller
   * @return seller
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SELLER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RepoSeller getSeller() {
    return seller;
  }


  @JsonProperty(JSON_PROPERTY_SELLER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSeller(RepoSeller seller) {
    this.seller = seller;
  }


  public RepoTradeExecutionSubmissionRequest tradeDetails(RepoTradeDetails tradeDetails) {
    
    this.tradeDetails = tradeDetails;
    return this;
  }

   /**
   * Get tradeDetails
   * @return tradeDetails
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRADE_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RepoTradeDetails getTradeDetails() {
    return tradeDetails;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTradeDetails(RepoTradeDetails tradeDetails) {
    this.tradeDetails = tradeDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeExecutionSubmissionRequest repoTradeExecutionSubmissionRequest = (RepoTradeExecutionSubmissionRequest) o;
    return Objects.equals(this.tradeId, repoTradeExecutionSubmissionRequest.tradeId) &&
        Objects.equals(this.buyer, repoTradeExecutionSubmissionRequest.buyer) &&
        Objects.equals(this.seller, repoTradeExecutionSubmissionRequest.seller) &&
        Objects.equals(this.tradeDetails, repoTradeExecutionSubmissionRequest.tradeDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, buyer, seller, tradeDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeExecutionSubmissionRequest {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    buyer: ").append(toIndentedString(buyer)).append("\n");
    sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
    sb.append("    tradeDetails: ").append(toIndentedString(tradeDetails)).append("\n");
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

