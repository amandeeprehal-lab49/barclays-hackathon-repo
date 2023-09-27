import { Injectable } from "@angular/core";
import { Observable, map, of, timer } from "rxjs";
import { Role } from "src/app/app.component";
import { Blotter } from "src/models/blotter.model";

const mockBlotterRow: Blotter = {
    role: 'Dealer1',
    tradeId: 'UC1CWBLQAG46F0',
    counterParty: 'Client1',
    eventDate: new Date(),
    eventType: 'New Contract',
    cdmHashref: '441dd917',
    lineageRef: ''
}

@Injectable({
    providedIn: 'root',
})
export class DataService {

    getBlotterData(role: Role): Observable<Blotter[]> {
        return of([mockBlotterRow]);
    }

    listenForTradeExecutionEvents(role: Role): Observable<Blotter> {
        return timer(1000, 4000).pipe(map(() => mockBlotterRow));
    }

    listenForTradeClearingEvents(role: Role): Observable<Blotter> {
        return of(mockBlotterRow);
    }

    listenForTradeSettlementEvents(role: Role): Observable<Blotter> {
        return of(mockBlotterRow);
    }
}