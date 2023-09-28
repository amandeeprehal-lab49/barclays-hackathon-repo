//SPDX-License-Identifier: Unlicense
pragma solidity ^0.8.18;
import "@openzeppelin/contracts/proxy/transparent/TransparentUpgradeableProxy.sol";
import "@openzeppelin/contracts-upgradeable/access/OwnableUpgradeable.sol";

contract BarclaysRepo is OwnableUpgradeable {

    struct TradeMatchingInputs {
        string role;
        string tradeId;
        string counterparty;
        string eventDate;
        string eventType;
        string cdmHash;
        string lineageHash;
    }

    struct EconomicTerms {
        string effectiveDate;
        string maturityDate;
    }

    struct SettlementEvent {
        string dvpDate;
        string collateral;
        uint256 amount;
    }

    event TradeState(
        TradeMatchingInputs tradeInputs,
        EconomicTerms economicTerms,
        SettlementEvent settlementEvent
    );

    TradeMatchingInputs private tradeInputs;
    EconomicTerms private economicTerms;
    SettlementEvent private settlementEvent;

    function initialize(
        TradeMatchingInputs memory _tradeInputs,
        EconomicTerms memory _economicTerms,
        SettlementEvent memory _settlementEvent
    ) external initializer {
        tradeInputs = _tradeInputs;
        economicTerms = _economicTerms;
        settlementEvent = _settlementEvent;
        emit TradeState(_tradeInputs, _economicTerms, _settlementEvent);
    }

    function updateTradeState(
        TradeMatchingInputs memory _tradeInputs,
        EconomicTerms memory _economicTerms,
        SettlementEvent memory _settlementEvent
    ) public {
        tradeInputs = _tradeInputs;
        economicTerms = _economicTerms;
        settlementEvent = _settlementEvent;
        emit TradeState(_tradeInputs, _economicTerms, _settlementEvent);
    }
}

 