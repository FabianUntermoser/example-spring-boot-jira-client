package com.example.examplespringbootjiraclient;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraManagementRestController
{
    private static final Logger LOGGER = getLogger(JiraManagementRestController.class);

    final JiraClient jiraClient;

    public JiraManagementRestController(final JiraClient jiraClient)
    {
        this.jiraClient = jiraClient;
    }

    @GetMapping("/issues")
    public ResponseEntity<String> getIssues()
    {
        LOGGER.info("***REMOVED***ing Issues");
        return jiraClient.getIssues();
    }

    @GetMapping("/search-issues")
    public ResponseEntity<String> searchIssues()
    {
        LOGGER.info("Searching Issues");
        return jiraClient.searchIssues();
    }

}
