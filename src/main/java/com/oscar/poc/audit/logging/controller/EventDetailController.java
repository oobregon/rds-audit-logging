package com.oscar.poc.audit.logging.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.poc.audit.logging.mapper.EventDetailsMapper;
import com.oscar.poc.audit.logging.model.EventDetail;
import com.oscar.poc.audit.logging.requests.EventDetailRequest;
import com.oscar.poc.audit.logging.service.EventDetailService;
import com.oscar.poc.audit.logging.service.EventDifferenceService;

@RestController
public class EventDetailController {

	EventDetailService eventDetailService;
	
	EventDifferenceService eventDifferenceService;
	
	EventDetailsMapper mapper;
	
	public EventDetailController(EventDetailService eventDetailService,
			EventDetailsMapper mapper,
			EventDifferenceService eventDifference) {
		this.eventDetailService = eventDetailService;
		this.eventDifferenceService = eventDifference;
		this.mapper = mapper;
	}
	
	@PostMapping (value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createEventDetail(@RequestBody EventDetailRequest request) {
		EventDetail eventDetail = mapper.convertToEventDetail(request);
		eventDetailService.create(eventDetail);		
		return "POST done";
	}
	
	@PostMapping (value = "/nada")
	public String nada() {
		// eventDetailService.create(eventDetail);
		return "Este POST no hace nada";
	}
	
	@GetMapping (value = "/saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "HeyHeyHey";
	}
}
