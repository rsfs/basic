package client.model;

public class ApiResponse {

	private String result;

	private ApiResponse() {
	}

	static ApiResponse withResult(String resultMessage) {
		ApiResponse ApiResponse = new ApiResponse();
		ApiResponse.result = resultMessage;
		return ApiResponse;
	}

	static ApiResponse withError(String errorMessage) {
		ApiResponse ApiResponse = new ApiResponse();
		ApiResponse.result = errorMessage;
		return ApiResponse;
	}

	public String getResult() {
		return result;
	}

}