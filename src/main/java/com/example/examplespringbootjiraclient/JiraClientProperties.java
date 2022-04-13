package com.example.examplespringbootjiraclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jira.client")
public class JiraClientProperties
{
    private String username;
    private String password;
    private String url;

    public String getUsername()
    {
        return username;
    }

    public JiraClientProperties setUsername(final String username)
    {
        this.username = username;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public JiraClientProperties setPassword(final String password)
    {
        this.password = password;
        return this;
    }

    public String getUrl()
    {
        return url;
    }

    public JiraClientProperties setUrl(final String url)
    {
        this.url = url;
        return this;
    }

    @Override
    public String toString()
    {
        return "JiraClientConfiguration{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", url='" + url + '\'' +
            '}';
    }
}
