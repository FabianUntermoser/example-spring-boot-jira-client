package com.example.examplespringbootjiraclient;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examplespringbootjiraclient.openfeign.JiraFeignClient;
import com.example.examplespringbootjiraclient.resttemplate.JiraClient;

@RestController
public class JiraIntegrationRestController
{
    private static final Logger LOGGER = getLogger(JiraIntegrationRestController.class);

    final JiraClient jiraClient;
    final JiraFeignClient jiraFeignClient;

    public JiraIntegrationRestController(
        final JiraClient jiraClient,
        final JiraFeignClient jiraFeignClient)
    {
        this.jiraClient = jiraClient;
        this.jiraFeignClient = jiraFeignClient;
    }

    @GetMapping("/issues")
    public ResponseEntity<String> getIssues()
    {
        LOGGER.info("Searching Issues");
        return jiraClient.getIssues();
    }

    @PostMapping(value = "/search-issues", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> searchIssues(Map<String, ?> query)
    {
        LOGGER.info("Searching Issues");
        return jiraClient.searchIssues(query);
    }

    @PostMapping(value = "/search-issues2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> searchIssues2(Map<String, ?> query)
    {
        LOGGER.info("Searching Issues");
        return jiraFeignClient.searchIssues(query);
    }
}
