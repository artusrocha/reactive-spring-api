package com.example.demo2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {

	@Autowired
	private MyService service;

	@GetMapping
	public ResponseEntity<Map<String, Page>> get() {

		Map<String, Page> pages = new HashMap<>();
		pages.put("Page 1", service.get1() );
		pages.put("Page 2", service.get2() );
		pages.put("Page 3", service.get3() );
		
		ResponseEntity<Map<String, Page>> resp = ResponseEntity.ok(pages);
		return resp;
	}

}
