package com.oscar.poc.audit.logging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscar.poc.audit.logging.model.EventDifference;

public interface DaoEventDifferences extends JpaRepository<EventDifference, Integer> {

}