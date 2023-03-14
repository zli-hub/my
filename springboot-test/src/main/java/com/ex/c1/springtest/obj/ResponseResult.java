package com.ex.c1.springtest.obj;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T data;
	private String status;
	private String message;
	
	public ResponseResult() {}
	
	public ResponseResult(T data,Status status,String message) {
		this.data = data;
		this.status = status.value;
		this.message = message;
	}
	
	public enum Status {
		SUCCESS("00"),
		FAILED("11");
		
		private String value;
		private Status(String value) {
			this.value = value;
		}
	}
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status.value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
