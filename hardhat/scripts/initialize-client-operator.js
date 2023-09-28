const { Client } = require('@hashgraph/sdk');
require("dotenv").config();

function initializeClientOperator(myAccountId, myPrivateKey, network) {
    if (myAccountId == null || myPrivateKey == null) {
        throw new Error('Hedera client AccountId and PrivateKey must be present')
    }

    // Create connection to Hedera network using Hedera JS SDK
    const client = network === 'mainnet' ? Client.forMainnet() : Client.forTestnet();

    client.setOperator(myAccountId, myPrivateKey);

    return client;
}

module.exports = {
    initializeClientOperator,
}
