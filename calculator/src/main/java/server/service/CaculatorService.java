package server.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CaculatorService {
		
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	public BigDecimal subtract( BigDecimal a,  BigDecimal b) {
		return a.subtract(b);
	}

	public BigDecimal multiply( BigDecimal a,  BigDecimal b) {
		return a.multiply(b);
	}

	public BigDecimal divide(BigDecimal a,  BigDecimal b) {
		return a.divide(b, RoundingMode.HALF_EVEN);
	}

}
