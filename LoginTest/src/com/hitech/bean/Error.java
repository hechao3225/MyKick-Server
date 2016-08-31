package com.hitech.bean;

public class Error {

	public String model;
	public String message;

	public Error() {
		super();
	}

	public Error(String model, String message) {
		super();
		this.model = model;
		this.message = message;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [model=" + model + ", message=" + message + "]";
	}
}
