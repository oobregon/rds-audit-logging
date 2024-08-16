package com.oscar.poc.audit.logging.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
	
	@GetMapping (value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Pong";
	}

}
