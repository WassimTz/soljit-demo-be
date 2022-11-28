package com.soljit.touzene.demo.controller;

import com.soljit.touzene.demo.model.AuthenticationResponse;
import com.soljit.touzene.demo.proxy.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    SalesforceService salesforceService;

    @GetMapping("")
    public String home(){
        return "Salesforce DEMO Project";
    }
}
