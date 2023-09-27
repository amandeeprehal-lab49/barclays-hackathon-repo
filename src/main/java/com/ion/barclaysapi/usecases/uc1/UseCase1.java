package com.ion.barclaysapi.usecases.uc1;

import java.io.File;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ion.barclaysapi.client.Constants;
import com.ion.barclaysapi.client.api.TradeExecutionApiApi;
import com.ion.barclaysapi.client.model.RepoTradeExecutionSubmissionRequest;
import com.ion.barclaysapi.client.model.RepoTradeSubmissionResponse;

public class UseCase1 {
	
	
	public static void main(String[] args) {

//		String inputFolder = System.getProperty("repohack2023.uc1.input_dir");
		String inputFolder = "C:\\Users\\dlevantesi\\RepoHack2023\\RepoHack2023_Files\\uc1_trades";
		new UseCase1().processAllInputFiles(new File(inputFolder));
		
	}

	private TradeExecutionApiApi executionAPI ;
	
	public UseCase1() {
		this.executionAPI = new TradeExecutionApiApi();

	}
	
	public void processAllInputFiles(final File folder) {
		for (final File inputFile : folder.listFiles()) {
			processFile(inputFile);
		}
	}

	private void processFile(File inputFile) {
		try {
			System.out.println("Processing input file: " + inputFile.getName());

			ObjectMapper objectMapper = new ObjectMapper();
			RepoTradeExecutionSubmissionRequest repoTrade = objectMapper.readValue(inputFile, RepoTradeExecutionSubmissionRequest.class);

			String buyerName = repoTrade.getBuyer().getBuyerName();
			UUID xApiRequestId1 = UUID.randomUUID();

			String sellerName = repoTrade.getSeller().getSellerName();
			UUID xApiRequestId2 = UUID.randomUUID();

			String xSimulationDate = repoTrade.getTradeDetails().getTradeDate();

			try {
				System.out.println(String.format("Submitting trade for [%s] as-of [%s]. Request id: [%s].", buyerName, xSimulationDate, xApiRequestId1));
	
				RepoTradeSubmissionResponse buyerRequest = executionAPI.postExecutionRequest(
						xApiRequestId1,
						Constants.xParticipantId, 
						buyerName, 
						Constants.xApiKey, 
						xSimulationDate,
						repoTrade);
	
				System.out.println(xApiRequestId1 + ":" + buyerRequest);
			} catch (Exception e) {
				System.err.println("Exception when calling StartHereApi#getPublicPing");
				e.printStackTrace();
			}

			try {
				System.out.println(String.format("Submitting trade for [%s] as-of [%s]. Request id: [%s].", sellerName, xSimulationDate, xApiRequestId2));
				RepoTradeSubmissionResponse sellerRequest2 = executionAPI.postExecutionRequest(
						xApiRequestId2,
						Constants.xParticipantId, 
						sellerName,
						Constants.xApiKey, 
						xSimulationDate, 
						repoTrade);
	
				System.out.println(xApiRequestId2 + ":" + sellerRequest2);
			} catch (Exception e) {
				System.err.println("Exception when calling StartHereApi#getPublicPing");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.err.println("Exception when calling StartHereApi#getPublicPing");
			e.printStackTrace();
		}
	}
	
	
	
}
