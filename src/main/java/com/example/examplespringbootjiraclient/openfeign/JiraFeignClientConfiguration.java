package com.example.examplespringbootjiraclient.openfeign;

import feign.Logger;
import feign.auth.BasicAuth***REMOVED***Interceptor;

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
    public BasicAuth***REMOVED***Interceptor basicAuth***REMOVED***Interceptor(JiraClientConfiguration configuration)
    {
        return new BasicAuth***REMOVED***Interceptor(configuration.getUsername(), configuration.getPassword());
    }

}
