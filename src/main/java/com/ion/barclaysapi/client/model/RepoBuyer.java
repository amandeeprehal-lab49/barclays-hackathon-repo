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
 * RepoBuyer
 */
@JsonPropertyOrder({
  RepoBuyer.JSON_PROPERTY_BUYER_NAME,
  RepoBuyer.JSON_PROPERTY_BUYER_LEI,
  RepoBuyer.JSON_PROPERTY_BUYER_ACCOUNT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-25T22:42:46.793138+05:30[Asia/Kolkata]")
public class RepoBuyer {
  public static final String JSON_PROPERTY_BUYER_NAME = "buyer_name";
  private String buyerName;

  public static final String JSON_PROPERTY_BUYER_LEI = "buyer_lei";
  private String buyerLei;

  public static final String JSON_PROPERTY_BUYER_ACCOUNT = "buyer_account";
  private String buyerAccount;

  public RepoBuyer() {
  }

  public RepoBuyer buyerName(String buyerName) {
    
    this.buyerName = buyerName;
    return this;
  }

   /**
   * Get buyerName
   * @return buyerName
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BUYER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBuyerName() {
    return buyerName;
  }


  @JsonProperty(JSON_PROPERTY_BUYER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBuyerName(String buyerName) {
    this.buyerName = buyerName;
  }


  public RepoBuyer buyerLei(String buyerLei) {
    
    this.buyerLei = buyerLei;
    return this;
  }

   /**
   * Get buyerLei
   * @return buyerLei
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BUYER_LEI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBuyerLei() {
    return buyerLei;
  }


  @JsonProperty(JSON_PROPERTY_BUYER_LEI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBuyerLei(String buyerLei) {
    this.buyerLei = buyerLei;
  }


  public RepoBuyer buyerAccount(String buyerAccount) {
    
    this.buyerAccount = buyerAccount;
    return this;
  }

   /**
   * Get buyerAccount
   * @return buyerAccount
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BUYER_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBuyerAccount() {
    return buyerAccount;
  }


  @JsonProperty(JSON_PROPERTY_BUYER_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBuyerAccount(String buyerAccount) {
    this.buyerAccount = buyerAccount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoBuyer repoBuyer = (RepoBuyer) o;
    return Objects.equals(this.buyerName, repoBuyer.buyerName) &&
        Objects.equals(this.buyerLei, repoBuyer.buyerLei) &&
        Objects.equals(this.buyerAccount, repoBuyer.buyerAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerName, buyerLei, buyerAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoBuyer {\n");
    sb.append("    buyerName: ").append(toIndentedString(buyerName)).append("\n");
    sb.append("    buyerLei: ").append(toIndentedString(buyerLei)).append("\n");
    sb.append("    buyerAccount: ").append(toIndentedString(buyerAccount)).append("\n");
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

