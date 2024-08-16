package com.oscar.poc.audit.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.poc.audit.logging.dao.DaoEventDifferences;
import com.oscar.poc.audit.logging.model.EventDifference;

@Service
public class EventDifferenceServiceImpl implements EventDifferenceService {
	
	@Autowired
	private DaoEventDifferences daoEventDifferences;

	@Override
	public void create(EventDifference eventDifference) {
		daoEventDifferences.save(eventDifference);
	}
}
