package com.example.examplespringbootjiraclient.openfeign;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

import org.springframework.context.annotation.Bean;

import com.example.examplespringbootjiraclient.JiraClientConfiguration;

public class JiraFeignClientConfiguration
{

    @Bean
    public Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(JiraClientConfiguration configuration)
    {
        String username = configuration.getUsername();
        String password = configuration.getPassword();
        return new BasicAuthRequestInterceptor(username, password);
    }

}
