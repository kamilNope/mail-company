package com.example.maildistributorservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maildistributorservice.client.MailOfficeClient;

@RestController
public class DistributorController {

    final MailOfficeClient mailOfficeClient;

    public DistributorController(MailOfficeClient mailOfficeClient){
        this.mailOfficeClient = mailOfficeClient;
    }

    @GetMapping("/mail")
    public String getMail(){
        return mailOfficeClient.getMail();
    }

}
