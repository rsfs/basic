package client.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Operation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private BigDecimal operatorA;
	private BigDecimal operatorB;
	private String action;

	public Operation(UUID id, BigDecimal operatorA, BigDecimal operatorB, String action) {
		super();
		this.id = id;
		this.operatorA = operatorA;
		this.operatorB = operatorB;
		this.action = action;
	}
	
	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getOperatorA() {
		return operatorA;
	}
	public void setOperatorA(BigDecimal operatorA) {
		this.operatorA = operatorA;
	}
	public BigDecimal getOperatorB() {
		return operatorB;
	}
	public void setOperatorB(BigDecimal operatorB) {
		this.operatorB = operatorB;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
