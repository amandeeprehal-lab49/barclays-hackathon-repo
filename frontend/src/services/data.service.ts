import { Injectable } from "@angular/core";
import { Observable, Subject, from, map, of, tap, timer } from "rxjs";
import { Role } from "src/app/app.component";
import { Blotter } from "src/models/blotter.model";
import axios from "axios";
import { ethers } from "ethers";
import Web3 from "web3";
import { BarclaysRepoABI } from "./BarclaysRepoABI";

const mockBlotterRow: Partial<Blotter> = {
    role: 'Dealer1',
    tradeId: 'UC1CWBLQAG46F0',
    counterParty: 'Client1',
    eventDate: new Date(),
    eventType: 'New Contract',
    cdmHash: '441dd917',
    lineageHash: ''
}

const BASE_URL = "https://testnet.mirrornode.hedera.com";

@Injectable({
    providedIn: 'root',
})
export class DataService {

    blotterData$ = new Subject<Partial<Blotter>[] | Partial<Blotter>>();

    contractAddress = '0.0.2956116';// 0.0.2901598

    listenForTradeEvents(role: Role) {
        this.getEvents(this.contractAddress, true);

        // for testing
        // timer(1000, 4000).pipe(map(() => mockBlotterRow)).subscribe(() => this.blotterData$.next(mockBlotterRow))
    }

    private toHex = (data: any) => {
        return data instanceof Uint8Array ? ethers.utils.hexlify(data) : data;
    };

    private async readRecords(url: string, items: any[], key: string | undefined | null = null) {
        console.log("- Request url:", url);
        const data = (await axios.get(url))?.data;
        const records = key ? data?.[key] ?? [] : [data];
        const next = data?.links?.next;
        items.push(...records);
        return next ? BASE_URL + next : next;
    }

    public async getEvents(contractId: string, delayRequired: boolean = false) {
        console.log(`- Getting event(s) from mirror for contract id = ${contractId}`);
        if (delayRequired) {
            console.log(`- Waiting 10s to allow transaction propagation to mirror`);
            await new Promise((resolve) => setTimeout(resolve, 10000));
        }

        const allLogs: any[] = [];
        let url = `${BASE_URL}/api/v1/contracts/${contractId}/results/logs?order=asc&limit=100`;
        while ((url = await this.readRecords(url, allLogs, "logs")));
        const events = await this.decodeLog(allLogs);
        events.forEach((value: any, key: string) => {
            console.log(key, "=>", value);
            if (key === 'TradeState') {
                value.forEach((individualTradeEvent: any) => {
                    const rowData = {
                        // TradeMatchingInputs
                        role: individualTradeEvent.tradeInputs['role'],
                        tradeId: individualTradeEvent.tradeInputs['tradeId'],
                        counterParty: individualTradeEvent.tradeInputs['counterparty'],
                        eventDate: individualTradeEvent.tradeInputs['eventDate'],
                        eventType: individualTradeEvent.tradeInputs['eventType'],
                        cdmHash: individualTradeEvent.tradeInputs['cdmHash'],
                        lineageHash: individualTradeEvent.tradeInputs['lineageHash'],

                        // Economic Terms
                        effectiveDate: individualTradeEvent.economicTerms['effectiveDate'],
                        maturityDate: individualTradeEvent.economicTerms['maturityDate'],

                        // Settlement Event
                        dvpDate: individualTradeEvent.settlementEvent['dvpDate'],
                        collateral: individualTradeEvent.settlementEvent['collateral'],
                        amount: individualTradeEvent.settlementEvent['amount'],
                    };
                    this.blotterData$.next(rowData);
                })
            }
        });

        // // const blotterData = events.get('TradeState') || [].reduce((_blotterData, _event) => {
        // //     const { tradeInputs, economicTerms, settlementEvent } = _event;
        // //     const rowData = {
        // //         // TradeMatchingInputs
        // //         role: tradeInputs['role'],
        // //         tradeId: tradeInputs['tradeId'],
        // //         counterParty: tradeInputs['counterParty'],
        // //         eventDate: tradeInputs['eventDate'],
        // //         eventType: tradeInputs['eventType'],
        // //         cdmHash: tradeInputs['cdmHash'],
        // //         lineageHash: tradeInputs['lineageHash'],

        // //         // Economic Terms
        // //         effectiveDate: economicTerms['effectiveDate'],
        // //         maturityDate: economicTerms['maturityDate'],

        // //         // Settlement Event
        // //         dvpDate: settlementEvent['dvpDate'],
        // //         collateral: settlementEvent['collateral'],
        // //         amount: settlementEvent['amount'],
        // //     }
        // //     console.log(rowData)
        // //     _blotterData.push(rowData);
        // //     return _blotterData;
        // // }, [] as Partial<Blotter>[])

        // console.log(blotterData)

        // this.blotterData$.next(blotterData);
    }

    ERROR_ABI: any = {
        inputs: [{ internalType: "string", name: "", type: "string" }],
        name: "Error",
        type: "error",
    };

    PANIC_ABI: any = {
        inputs: [{ internalType: "uint256", name: "", type: "uint256" }],
        name: "Panic",
        type: "error",
    };

    public getSignatureToABIMap = async () => {
        const web3 = new Web3();
        const signatureToAbiMap: Map<string, any> = new Map();
        signatureToAbiMap.set("0x08c379a0", this.ERROR_ABI);
        signatureToAbiMap.set("0x4e487b71", this.PANIC_ABI);

        const contractInfo = BarclaysRepoABI;

        for (const eachABI of contractInfo.abi) {
            const contractInterface = new ethers.utils.Interface(
                contractInfo.abi,
            );
            if (eachABI.type === "event") {
                const eventFragment = contractInterface.getEvent(eachABI.name);
                const topicHash = contractInterface.getEventTopic(eventFragment);
                signatureToAbiMap.set(topicHash, contractInterface);
            } else if (eachABI.type === "error") {
                const eventFragment = contractInterface.getError(eachABI.name);
                const hash = contractInterface.getSighash(eventFragment);
                signatureToAbiMap.set(hash, contractInterface);
            }
        }

        return signatureToAbiMap;
    };

    public async decodeLog(logs: any[]) {
        console.log("- Events count:", logs.length);
        const eventsMap = new Map<string, any[]>();

        const signatureMap = await this.getSignatureToABIMap();
        for (const log of logs) {
            try {
                const data = this.toHex(log.data);
                const topics = log.topics.map(this.toHex);
                const contractInterface = signatureMap.get(topics[0]);
                if (contractInterface) {
                    console.log(contractInterface)
                    const event = contractInterface.parseLog({ data, topics });
                    const events = eventsMap.get(event.name) ?? [];
                    eventsMap.set(event.name, [
                        ...events,
                        this.getEventArgumentsByName(event.args, event.name),
                    ]);
                } else {
                    console.log(`- No mapping found for topic = ${topics[0]}`);
                }
            } catch (e: any) {
                console.log(e);
            }
        }

        let mappedItems = 0;
        eventsMap.forEach((items: any[]) => (mappedItems += items.length));
        console.log("- Mapping count:", mappedItems);

        return eventsMap;
    }

    isIterable(value: any): boolean {
        if (value === undefined || value === null) {
            return false;
        }
        return typeof value[Symbol.iterator] === "function";
    }

    private getEventArgumentsByName(
        args: any,
        eventName: string,
        excludedKeys: string[] = ["__length__"],
    ) {
        const namedArguments: Record<string, any> = {};
        for (const key in args) {
            if (Number.isNaN(Number(key)) && !excludedKeys.includes(key)) {
                const arg = args[key];
                const refilter = this.isIterable(arg) && !Array.isArray(arg) && typeof arg !== "string";

                namedArguments[key] = refilter
                    ? this.getEventArgumentsByName(arg, eventName, excludedKeys)
                    : arg;
            }
        }
        return namedArguments;
    }
}
