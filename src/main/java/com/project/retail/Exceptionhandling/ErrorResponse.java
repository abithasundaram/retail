package com.project.retail.Exceptionhandling;

public class ErrorResponse {
	
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + ", path=" + path + "]";
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ErrorResponse(int status, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}
	private String path;

}
