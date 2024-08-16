package com.oscar.poc.audit.logging.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDetailRequest {

	@JsonProperty("dttm")
	private String dttm;

	@JsonProperty("x_enelx_trace_id")
	private String enelxTraceId;

	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("environment")
	private String environment;
	
	private String locationHost;
	
	private String locationPath;

	@JsonProperty("operation")
	private String operation;

	@JsonProperty("service")
	private String service;

	private String serviceDttm;

	@JsonProperty("user_id")
	private String userId;

	private List<EventDifferenceRequest> eventDifferences = new ArrayList<>();

	// private List<EventValidationError> eventValidationErrors;

	public EventDetailRequest() {
	}
	
	@JsonProperty("location")
	private void unpackNestedLocation(Map<String,Object> location) {
		this.locationPath = (String)location.get("path");
		this.locationHost = (String)location.get("host");
	}
	
	@JsonProperty("details")
	private void unpackNestedDetail(Map<String,Object> details) {
		Map<String,String> traceIds = (Map<String,String>)details.get("trace_ids");
		Map<String,String> meta = (Map<String,String>)details.get("meta");
		List<Map<String,String>> diffs = (details.get("diffs") == null) ? new ArrayList() : (List<Map<String,String>>)details.get("diffs");
		this.enelxTraceId = traceIds.get("x_enelx_trace_id");
		this.environment = meta.get("environment");
		for (Map<String,String> diff : diffs) {
			EventDifferenceRequest eventDifference = new EventDifferenceRequest();
			eventDifference.setFromValue(diff.get("from"));
			eventDifference.setKey(diff.get("key"));
			eventDifference.setToValue(diff.get("to"));
			this.eventDifferences.add(eventDifference);
		}
	}

	public String getDttm() {
		return this.dttm;
	}

	public void setDttm(String dttm) {
		this.dttm = dttm;
	}

	public String getEnelxTraceId() {
		return this.enelxTraceId;
	}

	public void setEnelxTraceId(String enelxTraceId) {
		this.enelxTraceId = enelxTraceId;
	}

	public String getEntitiyId() {
		return this.entityId;
	}

	public void setEntitiyId(String entitiyId) {
		this.entityId = entitiyId;
	}

	public String getEnvironmet() {
		return this.environment;
	}

	public void setEnvironmet(String environmet) {
		this.environment = environmet;
	}

	public String getLocationHost() {
		return this.locationHost;
	}

	public void setLocationHost(String locationHost) {
		this.locationHost = locationHost;
	}

	public String getLocationPath() {
		return this.locationPath;
	}
	

	public void setLocationPath(String locationPath) {
		this.locationPath = locationPath;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceDttm() {
		return this.serviceDttm;
	}

	public void setServiceDttm(String serviceDttm) {
		this.serviceDttm = serviceDttm;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<EventDifferenceRequest> getEventDifferences() {
		return this.eventDifferences;
	}

	public void setEventDifferences(List<EventDifferenceRequest> eventDifferences) {
		this.eventDifferences = eventDifferences;
	}

//	public List<EventValidationError> getEventValidationErrors() {
//		return this.eventValidationErrors;
//	}
//
//	public void setEventValidationErrors(List<EventValidationError> eventValidationErrors) {
//		this.eventValidationErrors = eventValidationErrors;
//	}
}
