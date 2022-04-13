# Example Spring Boot Jira Client
Showcase of how to consume the 
[Jira Server REST Api](https://developer.atlassian.com/server/jira/platform/rest-apis/)
with Spring.

## Configuration
Configure credentials and the API base path in a `application.properties` file.
```properties
jira.client.username=
jira.client.password=
jira.client.url=
```

## Build & Run
```sh
mvn clean package
```

## Rest Clients 
- The `JiraClient` uses `RestTemplate`.
- The `JiraFeignClient` uses `OpenFeign`.

Both Clients provide a ``searchIssues()`` method that queries the configured Jira instance
for all Issues with status `New` in the project `MyProject`.