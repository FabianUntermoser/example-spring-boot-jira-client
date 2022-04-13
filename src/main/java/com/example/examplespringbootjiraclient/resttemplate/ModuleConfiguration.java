package com.example.examplespringbootjiraclient.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.examplespringbootjiraclient.JiraClientProperties;

@Component
public class ModuleConfiguration
{

    @Bean
    public JiraClient jiraClient(JiraClientProperties configuration)
    {
        return new JiraClient(configuration);
    }

}
