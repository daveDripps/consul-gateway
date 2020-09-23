package com.thebeflastcodeforge.consullookup.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldDelegate {
    @Autowired
    RestTemplate restTemplate;
    
    private final Logger logger = LoggerFactory.getLogger(HelloWorldDelegate.class);
     
    public String callHelloServiceAndGetData() 
    {
        System.out.println("Consul Demo - Getting hello from service-mocker");
 
        String response = restTemplate.exchange("http://service-mocker/helloWorld",                                       
        		HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Hello from ServiceMocker: " + response + " -  " + new Date();
    }
     
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
