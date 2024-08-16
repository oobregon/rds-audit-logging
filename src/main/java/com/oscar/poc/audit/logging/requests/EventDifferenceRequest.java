package com.oscar.poc.audit.logging.requests;

public class EventDifferenceRequest {

	private String fromValue;

	private String key;

	private String toValue;

	public EventDifferenceRequest() {
	}

	public String getFromValue() {
		return this.fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getToValue() {
		return this.toValue;
	}

	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
}
