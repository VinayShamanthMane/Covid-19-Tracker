package org.shamanth.CoronaVirusTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class VaccineLocator {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping()
	public String vaccineAvailabityFinder() {
		return "vaccineAvaliability";
	}
	
}
