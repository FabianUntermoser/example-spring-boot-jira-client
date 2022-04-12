package com.example.examplespringbootjiraclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupRunner.class);

    final JiraClient jiraClient;
    final JiraClientConfiguration jiraClientConfiguration;

    public StartupRunner(final JiraClient jiraClient,
        final JiraClientConfiguration jiraClientConfiguration)
    {
        this.jiraClient = jiraClient;
        this.jiraClientConfiguration = jiraClientConfiguration;
    }

    @Override
    public void run(final String... args) throws Exception
    {
        LOGGER.info("Jira Client Configuration {}", jiraClientConfiguration);
        LOGGER.info("response {}", jiraClient.searchIssues());
    }
}
