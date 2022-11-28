package com.soljit.touzene.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationResponse {
    @JsonProperty(value = "access_token")
    String accessToken;
    @JsonProperty(value = "instance_url")
    String instanceUrl;
    @JsonProperty(value = "id")
    String id;
    @JsonProperty(value = "token_type")
    String tokenType;
    @JsonProperty(value = "issued_at")
    String issuedAt;
    @JsonProperty(value = "signature")
    String signature;
}


