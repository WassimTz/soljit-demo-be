package com.soljit.touzene.demo.proxy;

import com.soljit.touzene.demo.exception.AuthException;
import com.soljit.touzene.demo.exception.CandidatureException;
import com.soljit.touzene.demo.helper.Helper;
import com.soljit.touzene.demo.model.AllCandidatureResponse;
import com.soljit.touzene.demo.model.AuthenticationResponse;
import com.soljit.touzene.demo.model.CandidatureCreationModel;
import com.soljit.touzene.demo.model.CandidatureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SalesforceService {
    @Autowired
    Helper helper;
    @Value("${salesforce.instance.base-url}")
    String authBaseUrl;

    @Value("${salesforce.instance.client-id}")
    String clientId;

    @Value("${salesforce.instance.secret}")
    String secret;

    @Value("${salesforce.instance.username}")
    String username;

    @Value("${salesforce.instance.password}")
    String password;

    @Value("${salesforce.instance.instance-url}")
    String instanceUrl;


    public AuthenticationResponse callAuth() {
        WebClient client = helper.webClientBuilder()
                .baseUrl(authBaseUrl)
                .defaultHeader("Content-Type", "application/x-www-form-urlencoded")
                .defaultHeader("Accept", "application/json")
                .build();
        try {
            AuthenticationResponse res = client.post()
                    .uri(uriBuilder -> uriBuilder
                            .path("/oauth2/token")
                            .queryParam("grant_type", "password")
                            .queryParam("client_id", clientId)
                            .queryParam("client_secret", secret)
                            .queryParam("username", username)
                            .queryParam("password", password)
                            .build())
                    .retrieve()
                    .bodyToMono(AuthenticationResponse.class)
                    .block();
            //instanceUrl = res.getInstanceUrl();
            return res;
        } catch (Exception e) {
            throw new AuthException(AuthException.INVALID_INFORMATION);
        }
    }

    public CandidatureModel callCandidature(String authorization, String id) {
        WebClient client = helper.webClientBuilder()
                .baseUrl(instanceUrl)
                .defaultHeader("Authorization", authorization)
                .build();

        try {
            CandidatureModel response =    client.get()
                    .uri("/data/v55.0/sobjects/Candidature__c/" + id)
                    .retrieve()
                    .bodyToMono(CandidatureModel.class)
                    .block();
            return response;
        } catch (Exception e) {
            throw new CandidatureException(CandidatureException.INVALID_CALL);
        }
    }

    public AllCandidatureResponse callAllCandidature(String authorization) {
        WebClient client = helper.webClientBuilder()
                .baseUrl(instanceUrl)
                .defaultHeader("Authorization", authorization)
                .build();

        try {
            AllCandidatureResponse response =    client.get()
                    .uri("/data/v55.0/sobjects/Candidature__c/")
                    .retrieve()
                    .bodyToMono(AllCandidatureResponse.class)
                    .block();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CandidatureException(CandidatureException.INVALID_CALL);
        }
    }

    public CandidatureCreationModel callCreateCandidature(String authorization, CandidatureModel candidatureModel) {
        WebClient client = helper.webClientBuilder()
                .baseUrl(instanceUrl)
                .defaultHeader("Authorization", authorization)
                .build();
        System.out.println("---> " + candidatureModel.toString());
        try {
            CandidatureCreationModel response =    client.post()
                    .uri("/data/v55.0/sobjects/Candidature__c/")
                    .bodyValue(candidatureModel)
                    .retrieve()
                    .bodyToMono(CandidatureCreationModel.class)
                    .block();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CandidatureException(CandidatureException.INVALID_CALL);
        }

    }

    public CandidatureCreationModel callEditCandidature(String authorization, CandidatureModel candidatureModel, String id) {
        WebClient client = helper.webClientBuilder()
                .baseUrl(instanceUrl)
                .defaultHeader("Authorization", authorization)
                .build();
        System.out.println("---> " + candidatureModel.toString());
        try {
            CandidatureCreationModel response =    client.patch()
                    .uri("/data/v55.0/sobjects/Candidature__c/"+id)
                    .bodyValue(candidatureModel)
                    .retrieve()
                    .bodyToMono(CandidatureCreationModel.class)
                    .block();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CandidatureException(CandidatureException.INVALID_CALL);
        }

    }
}
