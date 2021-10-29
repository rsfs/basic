package client.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import client.model.Operation;

@Component
public class SenderClientService {

	private final RabbitTemplate template;

	private final DirectExchange directExchange;
	public static final String ROUTING_KEY = "old.car";

	public SenderClientService(DirectExchange directExchange, RabbitTemplate template) {
		this.directExchange = directExchange;
		this.template = template;
	}

	public String send(Operation op) {
		System.out
				.println("Sending Message: " + op.getAction() + " a:" + op.getOperatorA() + " b:" + op.getOperatorB());
		return template.convertSendAndReceiveAsType(directExchange.getName(), ROUTING_KEY, op,
				new ParameterizedTypeReference<>() {
				});
	}

}
