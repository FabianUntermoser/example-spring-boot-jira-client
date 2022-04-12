package com.example.examplespringbootjiraclient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModuleConfiguration
{

    @Bean
    public JiraClient jiraClient(JiraClientConfiguration configuration)
    {
        return new JiraClient(configuration);
    }

}
