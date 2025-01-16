package com.sahmatinet.sahamati.util;
import java.util.UUID;

public class GenerateTxnId {
    public static void main(String[] args) {
        // Generate a random UUID
        String txnid = UUID.randomUUID().toString();

        // Print the txnid
        System.out.println("Generated txnid: " + txnid);
    }
}
