package com.example.mailofficeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MailOfficeServiceApplication {

    @Autowired EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(MailOfficeServiceApplication.class, args);
    }



    @RestController
    class MailController{

        @RequestMapping("/mail")
        public String sendMail() {
            return "Hello world! " + eurekaClient.getEurekaClientConfig();
        }


        @RequestMapping("/address/{instanceID}")
        public String getInstance(@PathVariable String instanceID) {
            return "Hello world! " + eurekaClient.getInstancesById(instanceID);
        }


    }
}
