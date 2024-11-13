package com.sahmatinet.sahamati.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sahmatinet.sahamati.model.DHPublicKey;
import com.sahmatinet.sahamati.model.DataItem;
import com.sahmatinet.sahamati.model.FIData;
import com.sahmatinet.sahamati.model.FIRequest;
import com.sahmatinet.sahamati.model.FIResponse;
import com.sahmatinet.sahamati.model.KeyMaterial;

@Service
public class FIFetchService {

	public FIResponse processRequest(FIRequest fiRequest) {
		// Example of creating a response (mocked data)
		FIResponse response = new FIResponse();
		response.setVersion("2.0.0");
		response.setTimestamp(Instant.now());
		response.setTransactionId(UUID.randomUUID());

		// Mocked FI data for demonstration
		List<FIData> fiData = new ArrayList<FIData>();
		FIData FIData = new FIData();
		FIData.setFipId("FIP-1");

		List<DataItem> dataItems = new ArrayList<DataItem>();
		DataItem dataItem = new DataItem();
		dataItem.setLinkRefNumber("XXXX-XXXX-XXXX");
		dataItem.setMaskedAccountNumber("XXXXXXXX4020");
		dataItem.setEncryptedFI("text");
		dataItems.add(dataItem);

		KeyMaterial keyMaterial = new KeyMaterial();
		keyMaterial.setCryptoAlgorithm("ECDH");
		keyMaterial.setCurve("Curve25519");
		keyMaterial.setParameters("cipher=AES/GCM/NoPadding;KeyPairGenerator=ECDH");

		DHPublicKey dhPublicKey = new DHPublicKey();
		dhPublicKey.setExpiry(Instant.now().plusSeconds(31536000)); // Example expiry one year from now
		dhPublicKey.setParameters("text");
		dhPublicKey.setKeyValue("text");

		keyMaterial.setDhPublicKey(dhPublicKey);
		keyMaterial.setNonce(UUID.randomUUID().toString());

		FIData.setData(dataItems);
		FIData.setKeyMaterial(keyMaterial);
		fiData.add(FIData);

		response.setFiData(fiData);
		return response;
	}
}
