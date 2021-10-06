package com.example.maildiscoveryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@EnableEurekaServer
@SpringBootApplication
public class MailDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailDiscoveryServiceApplication.class, args);
    }

    @RestController
    class ServiceInstanceController{

        @Autowired
        private EurekaClient eurekaClient;

        @RequestMapping("/services/{applicationId}")
        public List<?> serviceInstance(@PathVariable String applicationId) {
            return this.eurekaClient.getInstancesById(applicationId);
        }

    }



}
