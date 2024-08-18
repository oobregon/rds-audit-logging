package com.oscar.poc.audit.logging.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the event_details database table.
 * 
 */
@Entity
@Table(name="event_details")
@NamedQuery(name="EventDetail.findAll", query="SELECT e FROM EventDetail e")
public class EventDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private Integer eventId;
	
	//@Id
	@Column(name="audit_log_trace_id")
	private String auditLogTraceId;

	private String dttm;

	@Column(name="enelx_trace_id")
	private String enelxTraceId;

	//@Id // Esta es nueva
	//@GeneratedValue(strategy = GenerationType.IDENTITY)// Esta es nueva
	@Column(name="entity_id")
	private String entityId;

	@Column(name="environmet")
	private String environment;
	
	@Column(name="location_host")
	private String locationHost;
	
	@Column(name="location_path")
	private String locationPath;

	@Column(name="logged_by")
	private String loggedBy;

	private String operation;

	private String service;

	@Column(name="service_dttm")
	private String serviceDttm;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to EventDifference
	@OneToMany(mappedBy="eventDetail", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EventDifference> eventDifferences = new ArrayList<>();

	//bi-directional many-to-one association to EventValidationError
	@OneToMany(mappedBy="eventDetail")
	private List<EventValidationError> eventValidationErrors;

	public EventDetail() {
	}
	

	public String getAuditLogTraceId() {
		return this.auditLogTraceId;
	}

	public void setAuditLogTraceId(String auditLogTraceId) {
		this.auditLogTraceId = auditLogTraceId;
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

	public String getEntityId() {
		return this.entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
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

	public String getLoggedBy() {
		return this.loggedBy;
	}

	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
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

	public List<EventDifference> getEventDifferences() {
		return this.eventDifferences;
	}

	public void setEventDifferences(List<EventDifference> eventDifferences) {
		this.eventDifferences = eventDifferences;
	}

	public EventDifference addEventDifference(EventDifference eventDifference) {
		getEventDifferences().add(eventDifference);
		eventDifference.setEventDetail(this);

		return eventDifference;
	}

	public EventDifference removeEventDifference(EventDifference eventDifference) {
		getEventDifferences().remove(eventDifference);
		eventDifference.setEventDetail(null);

		return eventDifference;
	}

	public List<EventValidationError> getEventValidationErrors() {
		return this.eventValidationErrors;
	}

	public void setEventValidationErrors(List<EventValidationError> eventValidationErrors) {
		this.eventValidationErrors = eventValidationErrors;
	}

	public EventValidationError addEventValidationError(EventValidationError eventValidationError) {
		getEventValidationErrors().add(eventValidationError);
		eventValidationError.setEventDetail(this);

		return eventValidationError;
	}

	public EventValidationError removeEventValidationError(EventValidationError eventValidationError) {
		getEventValidationErrors().remove(eventValidationError);
		eventValidationError.setEventDetail(null);

		return eventValidationError;
	}

}