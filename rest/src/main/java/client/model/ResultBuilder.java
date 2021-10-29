package client.model;

import java.math.BigDecimal;

public class ResultBuilder {

	private ResultBuilder() {
	}

	public static ApiResponse getResult(Object result) {
		if (result != null)
			return ApiResponse.withResult(result.toString());
		return ApiResponse.withResult("Internal Error");
	}

	public static ApiResponse getResult(BigDecimal result) {
		return ApiResponse.withResult(result.toPlainString());
	}

	public static ApiResponse getResultFromError(String errorMessage) {
      return ApiResponse.withError(errorMessage);
   }
	
}