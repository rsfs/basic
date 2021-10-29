package server.consumer;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import server.model.Operation;
import server.service.CaculatorService;

@Component
public class Consumer {
	
	CaculatorService calculatorService;

    @RabbitListener(queues = "#{queue.name}", concurrency = "10")
    public BigDecimal receive(Operation operation) {
    	System.out.println("Message received!: " + operation.getAction());        
        BigDecimal result = executeOperation(operation);        
        System.out.println("Result: "+result);        
        return result;        
    }
	
    public BigDecimal executeOperation(Operation operation) {
        BigDecimal result;
        switch (operation.getAction()) {
            case "sum":
                result = calculatorService.sum(operation.getOperatorA(), operation.getOperatorB()); 
                break;
            case "subtract":
                result = calculatorService.subtract(operation.getOperatorA(), operation.getOperatorB());
                break;
            case "multiply":
                result = calculatorService.multiply(operation.getOperatorA(), operation.getOperatorB());
                break;
            default:
                result = calculatorService.divide(operation.getOperatorA(), operation.getOperatorB());
                break;
        }
        return result;
    }    
}
