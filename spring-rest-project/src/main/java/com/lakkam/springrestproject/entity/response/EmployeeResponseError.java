package com.lakkam.springrestproject.entity.response;

public class EmployeeResponseError {
	
	private int status;
	private String message;
	private long timestamp;
	
	public EmployeeResponseError() {
		// TODO Auto-generated constructor stub
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long l) {
		this.timestamp = l;
	}

}
