/**
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


export interface TradeBusinessEventsQueryRequest { 
    tradeId?: string;
    fmi: string;
    fromDate: string;
    toDate: string;
}

