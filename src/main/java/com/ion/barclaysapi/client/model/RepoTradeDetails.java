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
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * RepoTradeDetails
 */
@JsonPropertyOrder({
  RepoTradeDetails.JSON_PROPERTY_TRADE_DATE,
  RepoTradeDetails.JSON_PROPERTY_EFFECTIVE_DATE,
  RepoTradeDetails.JSON_PROPERTY_MATURITY_DATE,
  RepoTradeDetails.JSON_PROPERTY_REPO_RATE,
  RepoTradeDetails.JSON_PROPERTY_RATE_DAYCOUNT_CONVENTION,
  RepoTradeDetails.JSON_PROPERTY_COLLATERAL_ID,
  RepoTradeDetails.JSON_PROPERTY_COLLATERAL_NOTIONAL,
  RepoTradeDetails.JSON_PROPERTY_COLLATERAL_DIRTY_PRICE,
  RepoTradeDetails.JSON_PROPERTY_COLLATERAL_HAIRCUT,
  RepoTradeDetails.JSON_PROPERTY_TRADE_CCY,
  RepoTradeDetails.JSON_PROPERTY_CASH_AMOUNT,
  RepoTradeDetails.JSON_PROPERTY_TERMINATION_CASH_AMOUNT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-25T22:42:46.793138+05:30[Asia/Kolkata]")
public class RepoTradeDetails {
  public static final String JSON_PROPERTY_TRADE_DATE = "trade_date";
  private String tradeDate;

  public static final String JSON_PROPERTY_EFFECTIVE_DATE = "effective_date";
  private String effectiveDate;

  public static final String JSON_PROPERTY_MATURITY_DATE = "maturity_date";
  private String maturityDate;

  public static final String JSON_PROPERTY_REPO_RATE = "repo_rate";
  private BigDecimal repoRate;

  public static final String JSON_PROPERTY_RATE_DAYCOUNT_CONVENTION = "rate_daycount_convention";
  private String rateDaycountConvention;

  public static final String JSON_PROPERTY_COLLATERAL_ID = "collateral_id";
  private String collateralId;

  public static final String JSON_PROPERTY_COLLATERAL_NOTIONAL = "collateral_notional";
  private BigDecimal collateralNotional;

  public static final String JSON_PROPERTY_COLLATERAL_DIRTY_PRICE = "collateral_dirty_price";
  private BigDecimal collateralDirtyPrice;

  public static final String JSON_PROPERTY_COLLATERAL_HAIRCUT = "collateral_haircut";
  private BigDecimal collateralHaircut;

  public static final String JSON_PROPERTY_TRADE_CCY = "trade_ccy";
  private String tradeCcy;

  public static final String JSON_PROPERTY_CASH_AMOUNT = "cash_amount";
  private BigDecimal cashAmount;

  public static final String JSON_PROPERTY_TERMINATION_CASH_AMOUNT = "termination_cash_amount";
  private BigDecimal terminationCashAmount;

  public RepoTradeDetails() {
  }

  public RepoTradeDetails tradeDate(String tradeDate) {
    
    this.tradeDate = tradeDate;
    return this;
  }

   /**
   * Get tradeDate
   * @return tradeDate
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRADE_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTradeDate() {
    return tradeDate;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
  }


  public RepoTradeDetails effectiveDate(String effectiveDate) {
    
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   * Get effectiveDate
   * @return effectiveDate
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EFFECTIVE_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEffectiveDate() {
    return effectiveDate;
  }


  @JsonProperty(JSON_PROPERTY_EFFECTIVE_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }


  public RepoTradeDetails maturityDate(String maturityDate) {
    
    this.maturityDate = maturityDate;
    return this;
  }

   /**
   * Get maturityDate
   * @return maturityDate
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MATURITY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMaturityDate() {
    return maturityDate;
  }


  @JsonProperty(JSON_PROPERTY_MATURITY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaturityDate(String maturityDate) {
    this.maturityDate = maturityDate;
  }


  public RepoTradeDetails repoRate(BigDecimal repoRate) {
    
    this.repoRate = repoRate;
    return this;
  }

   /**
   * Get repoRate
   * @return repoRate
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_REPO_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getRepoRate() {
    return repoRate;
  }


  @JsonProperty(JSON_PROPERTY_REPO_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRepoRate(BigDecimal repoRate) {
    this.repoRate = repoRate;
  }


  public RepoTradeDetails rateDaycountConvention(String rateDaycountConvention) {
    
    this.rateDaycountConvention = rateDaycountConvention;
    return this;
  }

   /**
   * Get rateDaycountConvention
   * @return rateDaycountConvention
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_RATE_DAYCOUNT_CONVENTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRateDaycountConvention() {
    return rateDaycountConvention;
  }


  @JsonProperty(JSON_PROPERTY_RATE_DAYCOUNT_CONVENTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRateDaycountConvention(String rateDaycountConvention) {
    this.rateDaycountConvention = rateDaycountConvention;
  }


  public RepoTradeDetails collateralId(String collateralId) {
    
    this.collateralId = collateralId;
    return this;
  }

   /**
   * Get collateralId
   * @return collateralId
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_COLLATERAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCollateralId() {
    return collateralId;
  }


  @JsonProperty(JSON_PROPERTY_COLLATERAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollateralId(String collateralId) {
    this.collateralId = collateralId;
  }


  public RepoTradeDetails collateralNotional(BigDecimal collateralNotional) {
    
    this.collateralNotional = collateralNotional;
    return this;
  }

   /**
   * Get collateralNotional
   * @return collateralNotional
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_COLLATERAL_NOTIONAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getCollateralNotional() {
    return collateralNotional;
  }


  @JsonProperty(JSON_PROPERTY_COLLATERAL_NOTIONAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollateralNotional(BigDecimal collateralNotional) {
    this.collateralNotional = collateralNotional;
  }


  public RepoTradeDetails collateralDirtyPrice(BigDecimal collateralDirtyPrice) {
    
    this.collateralDirtyPrice = collateralDirtyPrice;
    return this;
  }

   /**
   * Get collateralDirtyPrice
   * @return collateralDirtyPrice
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_COLLATERAL_DIRTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getCollateralDirtyPrice() {
    return collateralDirtyPrice;
  }


  @JsonProperty(JSON_PROPERTY_COLLATERAL_DIRTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollateralDirtyPrice(BigDecimal collateralDirtyPrice) {
    this.collateralDirtyPrice = collateralDirtyPrice;
  }


  public RepoTradeDetails collateralHaircut(BigDecimal collateralHaircut) {
    
    this.collateralHaircut = collateralHaircut;
    return this;
  }

   /**
   * Get collateralHaircut
   * @return collateralHaircut
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_COLLATERAL_HAIRCUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getCollateralHaircut() {
    return collateralHaircut;
  }


  @JsonProperty(JSON_PROPERTY_COLLATERAL_HAIRCUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollateralHaircut(BigDecimal collateralHaircut) {
    this.collateralHaircut = collateralHaircut;
  }


  public RepoTradeDetails tradeCcy(String tradeCcy) {
    
    this.tradeCcy = tradeCcy;
    return this;
  }

   /**
   * Get tradeCcy
   * @return tradeCcy
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRADE_CCY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTradeCcy() {
    return tradeCcy;
  }


  @JsonProperty(JSON_PROPERTY_TRADE_CCY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTradeCcy(String tradeCcy) {
    this.tradeCcy = tradeCcy;
  }


  public RepoTradeDetails cashAmount(BigDecimal cashAmount) {
    
    this.cashAmount = cashAmount;
    return this;
  }

   /**
   * Get cashAmount
   * @return cashAmount
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CASH_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getCashAmount() {
    return cashAmount;
  }


  @JsonProperty(JSON_PROPERTY_CASH_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCashAmount(BigDecimal cashAmount) {
    this.cashAmount = cashAmount;
  }


  public RepoTradeDetails terminationCashAmount(BigDecimal terminationCashAmount) {
    
    this.terminationCashAmount = terminationCashAmount;
    return this;
  }

   /**
   * Get terminationCashAmount
   * @return terminationCashAmount
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TERMINATION_CASH_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getTerminationCashAmount() {
    return terminationCashAmount;
  }


  @JsonProperty(JSON_PROPERTY_TERMINATION_CASH_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTerminationCashAmount(BigDecimal terminationCashAmount) {
    this.terminationCashAmount = terminationCashAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeDetails repoTradeDetails = (RepoTradeDetails) o;
    return Objects.equals(this.tradeDate, repoTradeDetails.tradeDate) &&
        Objects.equals(this.effectiveDate, repoTradeDetails.effectiveDate) &&
        Objects.equals(this.maturityDate, repoTradeDetails.maturityDate) &&
        Objects.equals(this.repoRate, repoTradeDetails.repoRate) &&
        Objects.equals(this.rateDaycountConvention, repoTradeDetails.rateDaycountConvention) &&
        Objects.equals(this.collateralId, repoTradeDetails.collateralId) &&
        Objects.equals(this.collateralNotional, repoTradeDetails.collateralNotional) &&
        Objects.equals(this.collateralDirtyPrice, repoTradeDetails.collateralDirtyPrice) &&
        Objects.equals(this.collateralHaircut, repoTradeDetails.collateralHaircut) &&
        Objects.equals(this.tradeCcy, repoTradeDetails.tradeCcy) &&
        Objects.equals(this.cashAmount, repoTradeDetails.cashAmount) &&
        Objects.equals(this.terminationCashAmount, repoTradeDetails.terminationCashAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeDate, effectiveDate, maturityDate, repoRate, rateDaycountConvention, collateralId, collateralNotional, collateralDirtyPrice, collateralHaircut, tradeCcy, cashAmount, terminationCashAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeDetails {\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    maturityDate: ").append(toIndentedString(maturityDate)).append("\n");
    sb.append("    repoRate: ").append(toIndentedString(repoRate)).append("\n");
    sb.append("    rateDaycountConvention: ").append(toIndentedString(rateDaycountConvention)).append("\n");
    sb.append("    collateralId: ").append(toIndentedString(collateralId)).append("\n");
    sb.append("    collateralNotional: ").append(toIndentedString(collateralNotional)).append("\n");
    sb.append("    collateralDirtyPrice: ").append(toIndentedString(collateralDirtyPrice)).append("\n");
    sb.append("    collateralHaircut: ").append(toIndentedString(collateralHaircut)).append("\n");
    sb.append("    tradeCcy: ").append(toIndentedString(tradeCcy)).append("\n");
    sb.append("    cashAmount: ").append(toIndentedString(cashAmount)).append("\n");
    sb.append("    terminationCashAmount: ").append(toIndentedString(terminationCashAmount)).append("\n");
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

