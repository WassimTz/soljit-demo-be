package com.soljit.touzene.demo.helper;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class Helper {
    public WebClient.Builder webClientBuilder() {
            return WebClient.builder();
    }

    public void validateToken(String token, String signature){

    }
}
