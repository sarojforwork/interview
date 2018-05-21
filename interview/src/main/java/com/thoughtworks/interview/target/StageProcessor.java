package com.thoughtworks.interview.target;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.thoughtworks.interview.model.Product;
import com.thoughtworks.interview.service.ProductService;

@Component
public abstract class StageProcessor {
	
	@Autowired
	ProductService productService;
		
	@Autowired
	RestTemplateClient restTemplateClient;
	
	@Value("${baseurl}") String baseurl;
	@Value("${inputendpoint}") String inputendpoint;
	@Value("${outputendpoint}") String outputendpoint;
	@Value("${userId}") String userId;

	public final void execute() {
		fetchInput();
		postOutput(processInputAndFormulateOutput());
	}

	private void fetchInput() {
		String uri = baseurl + '/' + inputendpoint;
		HttpHeaders headers = new HttpHeaders();
	    headers.set("userId", userId);

	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    ResponseEntity<Product[]> result = restTemplateClient.getRestTemplate().exchange(uri, HttpMethod.GET, entity, Product[].class);
	    productService.setProducts(Arrays.asList(result.getBody()));
	}

	private ResponseEntity<String> postOutput(Object output) {
		String uri = baseurl  + '/' + outputendpoint; 
		
		HttpHeaders headers = new HttpHeaders();
	    headers.set("userId", userId);
	    headers.set("content-type", "application/json");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<?> httpEntity = new HttpEntity<Object>(output, headers);
	    
	    ResponseEntity<String> response = restTemplateClient.getRestTemplate().exchange(uri, HttpMethod.POST, httpEntity, String.class);
	    return response;
	}

	public abstract Object processInputAndFormulateOutput();
}
