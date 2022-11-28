package com.soljit.touzene.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatureException extends RuntimeException{
    public final static String MISSING_ID = "candidature.exception.missingId";
    public final static String INVALID_CALL = "candidature.exception.invalidCall";
    public CandidatureException(String message) {
        super(message);
    }
}
