package com.ebanx.heimdall.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeimdallController {

    @GetMapping("evaluate")
    public String evaluateNotification() {
        return "Heimdall";
    }

}
