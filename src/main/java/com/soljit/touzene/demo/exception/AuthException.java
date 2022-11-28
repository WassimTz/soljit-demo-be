package com.soljit.touzene.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthException  extends RuntimeException{
    public final static String INVALID_INFORMATION = "auth.exception.invalidInformation";
    public final static String AUTHORIZATION_MISSING = "auth.exception.missingAuthorization";
    public AuthException(String message) {
        super(message);
    }
}
