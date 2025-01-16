package com.sahmatinet.sahamati.activemq;

import org.springframework.stereotype.Component;

import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@Component
public class TokenMessageListener implements MessageListener {

	@Override
	public void onMessage(jakarta.jms.Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String messageContent = textMessage.getText();

				// Handle the message (for example, log it or process the token)
				System.out.println("Received message: " + messageContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception (logging, re-throwing, etc.)
		}

	}
}
