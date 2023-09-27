export interface Blotter {
    role: string;               // Dealer, ClientX
    tradeId: string;
    counterParty: string;       // Dealer, ClientX
    eventDate: string | Date;
    eventType: 'New Contract' | 'DVP Settlement' | 'Trade Termination';
    cdmHashref: string;
    lineageRef: string;
}