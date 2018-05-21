package com.thoughtworks.interview.target;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateClient {
	
	RestTemplate restTemplate;

	public RestTemplateClient() {
		restTemplate = new RestTemplate();
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
}
