package com.example.examplespringbootjiraclient;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JiraClient
{
    private static final Logger LOGGER = LoggerFactory.getLogger(JiraClient.class);
    public static final String REST_API_2_SEARCH = "/rest/api/2/search";

    private final RestTemplate restTemplate;
    private final JiraClientConfiguration configuration;
    private final String searchUrl;

    public JiraClient(JiraClientConfiguration configuration)
    {
        this.configuration = configuration;
        this.restTemplate = buildRestTemplate();
        this.searchUrl = this.configuration.getUrl() + REST_API_2_SEARCH;
    }

    private RestTemplate buildRestTemplate()
    {
        String username = configuration.getUsername();
        String password = configuration.getPassword();
        return new RestTemplateBuilder()
            .basicAuthentication(username, password)
            .build();
    }

    public ResponseEntity<String> getIssues()
    {
        LOGGER.info("requesting issues: {}", this.searchUrl);
        return restTemplate.getForEntity(this.searchUrl, String.class);
    }

    public ResponseEntity<String> searchIssues()
    {
        var map = Map.of(
            "jql", "project = MYPROJECT AND status = '***REMOVED*** New'",
            "fields", new String[]{"id", "key"});

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        var requestBody = new HttpEntity<>(map, headers);

        URI searchUri = URI.create(this.searchUrl);
        return restTemplate.postForEntity(searchUri, requestBody, String.class);
    }
}
