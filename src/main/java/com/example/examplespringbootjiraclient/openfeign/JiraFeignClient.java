package com.example.examplespringbootjiraclient.openfeign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
    name = "jira",
    url = "${jira.client.url}/rest/api/2",
    configuration = JiraFeignClientConfiguration.class)
public interface JiraFeignClient
{

    @GetMapping(value = "/search")
    ResponseEntity<String> getIssues();

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> searchIssues(Map<String, ?> query);

}
