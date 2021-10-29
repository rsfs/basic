package client.rest;

import static client.model.ResultBuilder.getResult;
import static client.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import client.model.ApiResponse;
import client.model.Operation;
import client.service.SenderClientService;

@RestController
public class CalculatorRestController {
	
	@Autowired
	SenderClientService senderClient;
	
	@GetMapping("/sum")
	public ApiResponse sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		return getResult(senderClient.send(createOperation (a, b, "sum")));					
	}

	@GetMapping("/subtract")
	public ApiResponse subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		return getResult(senderClient.send(createOperation (a, b, "subtract")));	
		
	}

	@GetMapping("/multiply")
	public ApiResponse multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		return getResult(senderClient.send(createOperation (a, b, "multiply")));	
	}

	@GetMapping("/divide")
	public ApiResponse divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		if (b.equals(BigDecimal.ZERO)) {
			return getResultFromError("Erro de entrada de dados: Divisão por zero!");
		}
		return getResult(senderClient.send(createOperation (a, b, "divide")));	
	}	
	
	public Operation createOperation (BigDecimal a, BigDecimal b, String operator) {
		Operation op = new Operation();
		op.setId(UUID.randomUUID());
		op.setOperatorA(a);
		op.setOperatorB(b);
		op.setAction(operator);
		return op;
	}
}