package com.oscar.poc.audit.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.poc.audit.logging.dao.DaoEventDetails;
import com.oscar.poc.audit.logging.model.EventDetail;

@Service
public class EventDetailServiceImpl implements EventDetailService {
	
	@Autowired
	DaoEventDetails daoClient;

	@Override
	public void create(EventDetail eventDetail) {
		daoClient.save(eventDetail);		
	}

	@Override
	public void addDifferences(EventDetail eventDetail) {
		daoClient.save(eventDetail);
	}

}
