export const BarclaysRepoABI = {
  "abi": [
    {
      "anonymous": false,
      "inputs": [
        {
          "indexed": false,
          "internalType": "uint8",
          "name": "version",
          "type": "uint8"
        }
      ],
      "name": "Initialized",
      "type": "event"
    },
    {
      "anonymous": false,
      "inputs": [
        {
          "indexed": true,
          "internalType": "address",
          "name": "previousOwner",
          "type": "address"
        },
        {
          "indexed": true,
          "internalType": "address",
          "name": "newOwner",
          "type": "address"
        }
      ],
      "name": "OwnershipTransferred",
      "type": "event"
    },
    {
      "anonymous": false,
      "inputs": [
        {
          "components": [
            {
              "internalType": "string",
              "name": "role",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "tradeId",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "counterparty",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventType",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "cdmHash",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "lineageHash",
              "type": "string"
            }
          ],
          "indexed": false,
          "internalType": "struct BarclaysRepo.TradeMatchingInputs",
          "name": "tradeInputs",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "effectiveDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "maturityDate",
              "type": "string"
            }
          ],
          "indexed": false,
          "internalType": "struct BarclaysRepo.EconomicTerms",
          "name": "economicTerms",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "dvpDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "collateral",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "amount",
              "type": "string"
            }
          ],
          "indexed": false,
          "internalType": "struct BarclaysRepo.SettlementEvent",
          "name": "settlementEvent",
          "type": "tuple"
        }
      ],
      "name": "TradeState",
      "type": "event"
    },
    {
      "inputs": [
        {
          "components": [
            {
              "internalType": "string",
              "name": "role",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "tradeId",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "counterparty",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventType",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "cdmHash",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "lineageHash",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.TradeMatchingInputs",
          "name": "_tradeInputs",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "effectiveDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "maturityDate",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.EconomicTerms",
          "name": "_economicTerms",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "dvpDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "collateral",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "amount",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.SettlementEvent",
          "name": "_settlementEvent",
          "type": "tuple"
        }
      ],
      "name": "initialize",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [],
      "name": "owner",
      "outputs": [
        {
          "internalType": "address",
          "name": "",
          "type": "address"
        }
      ],
      "stateMutability": "view",
      "type": "function"
    },
    {
      "inputs": [],
      "name": "renounceOwnership",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "address",
          "name": "newOwner",
          "type": "address"
        }
      ],
      "name": "transferOwnership",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "string",
          "name": "effectiveDate",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "maturityDate",
          "type": "string"
        }
      ],
      "name": "updateEconomicTerms",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "string",
          "name": "dvpDate",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "collateral",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "amount",
          "type": "string"
        }
      ],
      "name": "updateSettlementEvent",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "string",
          "name": "effectiveDate",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "maturityDate",
          "type": "string"
        }
      ],
      "name": "updateTradeMatchinInputs",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "string",
          "name": "role",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "tradeId",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "counterparty",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "eventDate",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "eventType",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "cdmHash",
          "type": "string"
        },
        {
          "internalType": "string",
          "name": "lineageHash",
          "type": "string"
        }
      ],
      "name": "updateTradeMatchingInputs",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "components": [
            {
              "internalType": "string",
              "name": "role",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "tradeId",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "counterparty",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "eventType",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "cdmHash",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "lineageHash",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.TradeMatchingInputs",
          "name": "_tradeInputs",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "effectiveDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "maturityDate",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.EconomicTerms",
          "name": "_economicTerms",
          "type": "tuple"
        },
        {
          "components": [
            {
              "internalType": "string",
              "name": "dvpDate",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "collateral",
              "type": "string"
            },
            {
              "internalType": "string",
              "name": "amount",
              "type": "string"
            }
          ],
          "internalType": "struct BarclaysRepo.SettlementEvent",
          "name": "_settlementEvent",
          "type": "tuple"
        }
      ],
      "name": "updateTradeState",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    }
  ]
}
