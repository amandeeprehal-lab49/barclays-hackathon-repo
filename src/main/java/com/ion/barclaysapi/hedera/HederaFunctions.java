package com.ion.barclaysapi.hedera;
import com.hedera.hashgraph.sdk.*;

import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

public final class HederaFunctions {

    private static final AccountId OPERATOR_ID = AccountId.fromString("0.0.78391");
    private static final PrivateKey OPERATOR_KEY = PrivateKey.fromString("302e020100300506032b65700422042014138f9d2fbcc9969d9efe28b7fc5281995587c2587ed62d19b78058241dd838");
    private static final Client client = Client.forName("testnet");
    private static final ContractId contractId = ContractId.fromString("0.0.2939972");

    static {
        client.setOperator(OPERATOR_ID, OPERATOR_KEY);
    }

    public static void main(String[] args) throws TimeoutException, PrecheckStatusException, ReceiptStatusException {
        HederaFunctions createAccountExample = new HederaFunctions();
//        createAccountExample.updateEconomics("23-10-2023", "24-10-2023");
//        createAccountExample.updateTradeMatching("newRole",
//                "newTradeld",
//                "newcounterParty",
//                "newEventDate",
//                "newEventType",
//                "CdmHash",
//                "lineageHash"
//        );
        createAccountExample.updateSettlementEvent("25-10-2023", "Collateral Bond", "10");
    }

    public void updateEconomics(String effectiveDate, String maturityDate) throws PrecheckStatusException, TimeoutException, ReceiptStatusException {
        ContractExecuteTransaction transaction = new ContractExecuteTransaction()
                .setContractId(contractId)
                .setGas(100_000_00)
                .setFunction("updateEconomicTerms", new ContractFunctionParameters()
                        .addString(effectiveDate)
                        .addString(maturityDate)
                );
        TransactionResponse txResponse = transaction.execute(client);
        TransactionReceipt receipt = txResponse.getReceipt(client);
        Status transactionStatus = receipt.status;
        System.out.println("The transaction consensus status is " + transactionStatus);
    }

    public void updateSettlementEvent(String dvpDate, String collateral, String amount) throws PrecheckStatusException, TimeoutException, ReceiptStatusException {
        ContractExecuteTransaction transaction = new ContractExecuteTransaction()
                .setContractId(contractId)
                .setGas(400_000)
                .setFunction("updateSettlementEvent", new ContractFunctionParameters()
                        .addString(dvpDate)
                        .addString(collateral)
                        .addString(amount)
                );
        TransactionResponse txResponse = transaction.execute(client);
        TransactionReceipt receipt = txResponse.getReceipt(client);
        Status transactionStatus = receipt.status;
        System.out.println("The transaction consensus status is " + transactionStatus);
    }

    public void updateTradeMatching(
            String role,
            String tradeId,
            String counterparty,
            String eventDate,
            String eventType,
            String cdmHash,
            String lineageHash
            ) throws PrecheckStatusException, TimeoutException, ReceiptStatusException {
        ContractExecuteTransaction transaction = new ContractExecuteTransaction()
                .setContractId(contractId)
                .setGas(100_000_00)
                .setFunction("updateTradeMatchingInputs", new ContractFunctionParameters()
                        .addString(role)
                        .addString(tradeId)
                        .addString(counterparty)
                        .addString(eventDate)
                        .addString(eventType)
                        .addString(cdmHash)
                        .addString(lineageHash)
                );
        TransactionResponse txResponse = transaction.execute(client);
        TransactionReceipt receipt = txResponse.getReceipt(client);
        Status transactionStatus = receipt.status;
        System.out.println("The transaction consensus status is " + transactionStatus);
    }
}