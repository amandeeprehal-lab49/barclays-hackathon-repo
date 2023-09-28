export interface Blotter {
    // TradeMatchingInputs
    role: string;               // Dealer, ClientX
    tradeId: string;
    counterParty: string;       // Dealer, ClientX
    eventDate: string | Date;
    eventType: 'New Contract' | 'DVP Settlement' | 'Trade Termination';
    cdmHash: string;
    lineageHash: string;

    // Economic Terms
    effectiveDate: string | Date;
    maturityDate: string | Date;

    // Settlement Event
    dvpDate: string | Date;
    collateral: string;
    amount: number;
}