package com.oscar.poc.audit.logging.service;

import com.oscar.poc.audit.logging.model.EventDetail;

public interface EventDetailService {
	
	public void create(EventDetail eventDetail);
	
	public void addDifferences(EventDetail eventDetail);

}
