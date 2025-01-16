package com.sahmatinet.sahamati.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class ActiveMQConfig {

	private String brokerURL = "tcp://localhost:61616"; // ActiveMQ Broker URL

	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(brokerURL);
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}

	@Bean
	public DefaultMessageListenerContainer messageListenerContainer(TokenMessageListener tokenMessageListener) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName("iam.token.response.queue"); // Name of the queue
		container.setMessageListener(tokenMessageListener); // Set your message listener
		return container;
	}
}
