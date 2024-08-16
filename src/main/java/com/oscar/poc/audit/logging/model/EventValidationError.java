package com.oscar.poc.audit.logging.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the event_validation_error database table.
 * 
 */
@Entity
@Table(name="event_validation_error")
@NamedQuery(name="EventValidationError.findAll", query="SELECT e FROM EventValidationError e")
public class EventValidationError implements Serializable {
	private static final long serialVersionUID = 1L;

	private String field;

	@Column(name="json_payload")
	private Object jsonPayload;

	private String message;

	@Id
	@ManyToOne
	@JoinColumn(name="audit_log_trace_id")
	private EventDetail eventDetail;

	public EventValidationError() {
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getJsonPayload() {
		return this.jsonPayload;
	}

	public void setJsonPayload(Object jsonPayload) {
		this.jsonPayload = jsonPayload;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EventDetail getEventDetail() {
		return this.eventDetail;
	}

	public void setEventDetail(EventDetail eventDetail) {
		this.eventDetail = eventDetail;
	}

}