package com.ex.c1.springtest.test;

import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Mono;

public class Test {
	public static void main(String[] args) {
		ExchangeFunction exchangeFunction = ExchangeFunctions.create(new ReactorClientHttpConnector());
		URI url = URI.create("http://localhost:8000/test");
		ClientRequest request = ClientRequest.create(HttpMethod.GET, url).build();
		Mono<String> bodyMono = exchangeFunction.exchange(request).flatMap(
				response -> response.bodyToMono(String.class));
		System.out.println("\nresult====>" + bodyMono.block());
	}
}
