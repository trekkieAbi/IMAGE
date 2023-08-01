package com.eureka.server.response;

public class ApiResponse {
	
	private String status;
	private Object data;
	private boolean success;
	public ApiResponse(String status, Object data, boolean success) {
		super();
		this.status = status;
		this.data = data;
		this.success = success;
	}
	public ApiResponse() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
