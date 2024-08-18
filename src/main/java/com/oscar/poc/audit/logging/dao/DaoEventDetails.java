package com.oscar.poc.audit.logging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscar.poc.audit.logging.model.EventDetail;

public interface DaoEventDetails extends JpaRepository<EventDetail, Integer> {

}
