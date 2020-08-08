package com.example.demo2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {

	@Autowired
	private MyService service;

	@GetMapping
	public Mono<ResponseEntity<Map<String, Page>>> get() {

		Mono<Page> r1 = service.get1();
		Mono<Page> r2 = service.get2();
		Mono<Page> r3 = service.get3();

		return Mono.zip(r1, r2, r3).flatMap(data -> {
			Map<String, Page> body = new HashMap<>();
			body.put("Page 1", data.getT1());
			body.put("Page 2", data.getT2());
			body.put("Page 3", data.getT3());
			ResponseEntity<Map<String, Page>> resp = ResponseEntity.ok(body);
			return Mono.just(resp);
		});

	}

}
