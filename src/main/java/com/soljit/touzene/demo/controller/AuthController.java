package com.soljit.touzene.demo.controller;

import com.soljit.touzene.demo.model.GenericResponseExtended;
import com.soljit.touzene.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public GenericResponseExtended login(){
        return authService.auth();
    }
}
