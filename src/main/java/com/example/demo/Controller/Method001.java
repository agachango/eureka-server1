package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/client")
public class Method001 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(){
        String url = "http://Eureka-Project-002/rest/server";
        return restTemplate.getForObject(url,String.class);
    }


}

@Configuration
class Config{
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
