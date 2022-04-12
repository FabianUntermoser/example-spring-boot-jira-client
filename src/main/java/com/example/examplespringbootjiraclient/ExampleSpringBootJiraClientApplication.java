package com.example.examplespringbootjiraclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleSpringBootJiraClientApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ExampleSpringBootJiraClientApplication.class, args);
    }
}
