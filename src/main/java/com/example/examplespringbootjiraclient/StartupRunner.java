package com.example.examplespringbootjiraclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupRunner.class);

    final JiraClientConfiguration jiraClientConfiguration;

    public StartupRunner(final JiraClientConfiguration jiraClientConfiguration)
    {
        this.jiraClientConfiguration = jiraClientConfiguration;
    }

    @Override
    public void run(final String... args) throws Exception
    {
        LOGGER.info("Jira Client Configuration {}", jiraClientConfiguration);
    }
}
