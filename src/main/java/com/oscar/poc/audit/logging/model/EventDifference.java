package com.oscar.poc.audit.logging.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the event_differences database table.
 * 
 */
@Entity
@Table(name="event_differences")
@NamedQuery(name="EventDifference.findAll", query="SELECT e FROM EventDifference e")
public class EventDifference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_diff_id")
	private Integer id;
	
	@Column(name="from_value")
	private String fromValue;

	private String key;

	@Column(name="to_value")
	private String toValue;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="audit_log_trace_id", referencedColumnName = "audit_log_trace_id")
	private EventDetail eventDetail;

	public EventDifference() {
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

	public EventDetail getEventDetail() {
		return this.eventDetail;
	}

	public void setEventDetail(EventDetail eventDetail) {
		this.eventDetail = eventDetail;
	}

}