package com.example.demo2;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class MyService {

	private static String baseUrl = "https://reqres.in";
	private static WebClient client = WebClient.create(baseUrl);

	public Page get1() {
		return doRequest(1);
	}

	public Page get2() {
		return doRequest(2);
	}

	public Page get3() {
		return doRequest(3);
	}

	private Page doRequest(Integer page) {
		return client.get().uri("/api/users?page={i}", page)
				.retrieve()
				.bodyToMono(Page.class)
				.timeout(Duration.ofMillis(10000L))
				.onErrorReturn(new Page())
				.block();
	}
}
