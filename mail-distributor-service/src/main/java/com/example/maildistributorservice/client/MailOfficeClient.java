package com.example.maildistributorservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "mail-office-service", url = "http://localhost:8002")
public interface MailOfficeClient {

    @RequestMapping("/mail")
    String getMail();

}
