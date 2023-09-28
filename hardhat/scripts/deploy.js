// We require the Hardhat Runtime Environment explicitly here. This is optional
// but useful for running the script in a standalone fashion through `node <script>`.
//
// You can also run a script with `npx hardhat run <script>`. If you do that, Hardhat
// will compile your contracts, add the Hardhat Runtime Environment's members to the
// global scope, and execute the script.
const hre = require("hardhat");
const { initializeClientOperator } = require('./initialize-client-operator');
const { AccountId, FileAppendTransaction, ContractFunctionParameters, ContractExecuteTransaction, ContractCallQuery, FileCreateTransaction, ContractCreateTransaction, PrivateKey, Hbar } = require('@hashgraph/sdk');
const fs = require("fs");
const os = require("os");

// Initialize client using testnet account
const clientAccountId = process.env.CLIENT_ACCOUNT_ID;
const clientPrivateKey = process.env.CLIENT_PRIVATE_KEY;
const client = initializeClientOperator(clientAccountId, clientPrivateKey, 'testnet');

async function main() {
  await hre.run("compile");
  console.log('Compilation operation successful');

  const contractId = await deployToHedera();

  console.log('Contract Address:', contractId);

  return contractId;

}

async function uploadBytecodeToHedera(bytecode) {
  console.log('\n////////// Creating and uploading smart contract files to Hedera testnet //////////');

  console.log('\n////////// Uploading contract //////////');
  console.log('Splitting contract file and uploading in chunks to prevent file to large errors');

  const bytecodeLength = bytecode.length;

  bytecodeFirstPart = bytecode.substring(0, bytecodeLength / 6);
  bytecodeSecondPart = bytecode.substring(bytecodeLength / 6, bytecodeLength * 2 / 6);
  bytecodeThirdPart = bytecode.substring(bytecodeLength * 2 / 6, bytecodeLength * 3 / 6);
  bytecodeFourthPart = bytecode.substring(bytecodeLength * 3 / 6, bytecodeLength * 4 / 6);
  bytecodeFifthPart = bytecode.substring(bytecodeLength * 4 / 6, bytecodeLength * 5 / 6);
  bytecodeSixthPart = bytecode.substring(bytecodeLength * 5 / 6);


  // Create a file on Hedera and store the hex-encoded bytecode
  // need to sign file transaction with keys so can append other parts of bytecode to it
  const fileKey = await PrivateKey.generateED25519();
  const filePublicKey = fileKey.publicKey;

  const fileCreateTx = new FileCreateTransaction()
      .setKeys([filePublicKey])           // sign file with public key
      .setContents(bytecodeFirstPart)
      .freezeWith(client);
  // sign file create transaction with fileKey (private)
  const signTx = await fileCreateTx.sign(fileKey);
  // Submit file to Hedera test net signing with the transaction fee payer key specified in client
  const submitTx = await signTx.execute(client);
  // Get receipt of the file create transaction
  const fileReceipt = await submitTx.getReceipt(client);
  // Get file ID from the receipt
  const bytecodeFileId = fileReceipt.fileId;

  console.log('First part of smart contractfile deployed to testnet')
  console.log('Smart contract byte code file ID:', bytecodeFileId.toString());

  // APPEND REST OF BYTECODE TO FILE
  // append second part of bytecode
  const secondReceipt = await appendFile(client, bytecodeFileId, bytecodeSecondPart, fileKey);
  console.log('Appending Second part of file status:', secondReceipt.status.toString());
  // append third part of bytecode
  const thirdReceipt = await appendFile(client, bytecodeFileId, bytecodeThirdPart, fileKey);
  console.log('Appending Third part of file status:', thirdReceipt.status.toString());
  // append fourth part of bytecode
  const fourthReceipt = await appendFile(client, bytecodeFileId, bytecodeFourthPart, fileKey);
  console.log('Appending Fourth part of file status:', fourthReceipt.status.toString());
  // append fifth part of bytecode
  const fifthReceipt = await appendFile(client, bytecodeFileId, bytecodeFifthPart, fileKey);
  console.log('Appending Fifth part of file status:', fifthReceipt.status.toString());
  // append sixth part of bytecode
  const sixthReceipt = await appendFile(client, bytecodeFileId, bytecodeSixthPart, fileKey);
  console.log('Appending Sixth part of file status:', sixthReceipt.status.toString());

  return bytecodeFileId
}

async function deployToHedera() {
  if (!client) {
    console.log("ERROR: No Hedera client initialized");
    return;
  }

  console.log('\n////////// Importing smart contract bytecode //////////');

  let contractJson = require('../artifacts/contracts/BarclaysRepo.sol/BarclaysRepo.json');
  const bytecode = contractJson.bytecode;

  const bytecodeFileId = await uploadBytecodeToHedera(bytecode);

  console.log('\n////////// Instantiate contract instance for deployed files //////////');
  const contractTx = new ContractCreateTransaction()
      .setBytecodeFileId(bytecodeFileId)  // Hedera file ID containing bytecode
      .setGas(1000000) // gas to instantiate contract (for transaction)
      .setMaxTransactionFee(new Hbar(20));

  // Submit transaction to Hedera testnet and execute
  const contractResponse = await contractTx.execute(client);
  // Get receipt of contract create transaction
  const contractReceipt = await contractResponse.getReceipt(client);
  // Get smart contract ID
  const newContractId = contractReceipt.contractId;

  console.log('Smart contract ID is (solidity address format):', newContractId.toSolidityAddress());
  console.log('Smart contract ID is:', newContractId.toString());
  return newContractId;
}

async function appendFile(client, bytecodeFileId, contents, fileKey) {
  const fileAppendSecondTx = await new FileAppendTransaction()
      .setFileId(bytecodeFileId)
      .setContents(contents)
      .setMaxTransactionFee(new Hbar(10))
      .freezeWith(client);

  const signSecondTx = await fileAppendSecondTx.sign(fileKey);
  const txSecondResponse = await signSecondTx.execute(client);
  return await txSecondResponse.getReceipt(client);
}

main()
.then((val) => {
  console.log('successfully deployed', val)
  process.exit(0);
})
.catch((error) => {
  console.error(error);
  process.exitCode = 1;
});
