package com.soljit.touzene.demo.service;

import com.soljit.touzene.demo.model.AuthenticationResponse;
import com.soljit.touzene.demo.model.GenericResponseExtended;
import com.soljit.touzene.demo.proxy.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    SalesforceService salesforceService;

    public GenericResponseExtended<AuthenticationResponse> auth() {
        AuthenticationResponse  res = salesforceService.callAuth();
        return new GenericResponseExtended<>(res);
    }
}
