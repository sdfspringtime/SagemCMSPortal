package com.CMSBACK.models;

public class Model {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Model() {
		super();
	}

	@Override
	public String toString() {
		return "Model [message=" + message + "]";
	}
	

}

