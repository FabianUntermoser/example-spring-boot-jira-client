package com.example.examplespringbootjiraclient;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.examplespringbootjiraclient.openfeign.JiraFeignClient;
import com.example.examplespringbootjiraclient.resttemplate.JiraClient;

@Component
public class StartupRunner implements CommandLineRunner
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupRunner.class);

    private static final Map<String, Serializable> SEARCH_QUERY = Map.of(
        "jql", "project = MYPROJECT AND status = 'New'",
        "fields", new String[]{"id", "key"});

    final JiraClient jiraClient;
    final JiraFeignClient jiraFeignClient;
    final JiraClientProperties jiraClientConfiguration;

    public StartupRunner(final JiraClient jiraClient,
        final JiraFeignClient jiraFeignClient,
        final JiraClientProperties jiraClientConfiguration)
    {
        this.jiraClient = jiraClient;
        this.jiraFeignClient = jiraFeignClient;
        this.jiraClientConfiguration = jiraClientConfiguration;
    }

    @Override
    public void run(final String... args) throws Exception
    {
        LOGGER.info("Jira Client Configuration {}", jiraClientConfiguration);

        LOGGER.info("response {}", jiraClient.searchIssues(SEARCH_QUERY));
        LOGGER.info("response {}", jiraFeignClient.searchIssues(SEARCH_QUERY));
    }
}
