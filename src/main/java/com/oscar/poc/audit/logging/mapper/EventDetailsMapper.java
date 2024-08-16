package com.oscar.poc.audit.logging.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.oscar.poc.audit.logging.model.EventDetail;
import com.oscar.poc.audit.logging.model.EventDifference;
import com.oscar.poc.audit.logging.requests.EventDetailRequest;
import com.oscar.poc.audit.logging.requests.EventDifferenceRequest;

@Component
public class EventDetailsMapper {
	
	public EventDetail convertToEventDetail(EventDetailRequest request) {
		EventDetail eventDetail = new EventDetail();
		List<EventDifference> differences = new ArrayList<>();
		eventDetail.setDttm(request.getDttm());
		eventDetail.setEnelxTraceId(request.getEnelxTraceId());
		eventDetail.setEntityId(request.getEntitiyId());
		eventDetail.setEnvironmet(request.getEnvironmet());
		eventDetail.setLocationHost(request.getLocationHost());
		eventDetail.setLocationPath(request.getLocationPath());
		eventDetail.setOperation(request.getOperation());
		eventDetail.setService(request.getService());
		eventDetail.setUserId(request.getUserId());
		// eventDetail.setAuditLogTraceId(UUID.randomUUID().toString());
		eventDetail.setAuditLogTraceId("e7d525f3-bf04-4d62-b328-72351d78ffa5");
		eventDetail.setLoggedBy(UUID.randomUUID().toString());
		eventDetail.setServiceDttm("2024-08-16T12:06:22");
		for(EventDifferenceRequest evDiffReq : request.getEventDifferences()) {
			EventDifference eventDifference = new EventDifference();
			eventDifference.setFromValue(evDiffReq.getFromValue());
			eventDifference.setKey(evDiffReq.getKey());
			eventDifference.setToValue(evDiffReq.getToValue());
			eventDifference.setEventDetail(eventDetail);			
			differences.add(eventDifference);
		}
		eventDetail.setEventDifferences(differences);
		return eventDetail;
	}
	
//	public EventDifference convertToEventDifferences(EventDifferenceRequest requestDiffs, EventDetail eventDetail) {
//		EventDifference eventDifference = new EventDifference();
//		eventDifference.setFromValue(requestDiffs.getFromValue());
//		eventDifference.setKey(requestDiffs.getKey());
//		eventDifference.setToValue(requestDiffs.getToValue());
//		//eventDifference.setEventDetail(eventDetail);
//		return eventDifference;
//	}
	
//	public List<EventDifference> convertToEventDifferencesV2(List<EventDifferenceRequest> requestDiffs, EventDetail eventDetail) {
//		List<EventDifference> differences = new ArrayList<>();
//		for(EventDifferenceRequest evDiffReq : requestDiffs) {
//			EventDifference eventDifference = new EventDifference();
//			eventDifference.setFromValue(evDiffReq.getFromValue());
//			eventDifference.setKey(evDiffReq.getKey());
//			eventDifference.setToValue(evDiffReq.getToValue());
//			eventDifference.setEventDetail(eventDetail);
//			differences.add(eventDifference);
//		}
//		return differences;
//	}

}
