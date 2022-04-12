package com.example.examplespringbootjiraclient.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.examplespringbootjiraclient.JiraClientConfiguration;

@Component
public class ModuleConfiguration
{

    @Bean
    public JiraClient jiraClient(JiraClientConfiguration configuration)
    {
        return new JiraClient(configuration);
    }

}
