package com.example.openapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "peter")
@Component
public class MyUrlConfigurationProperties {
    private List<MyUrl> urls;

    public MyUrlConfigurationProperties(List<MyUrl> urls) {
        this.urls = urls;
    }

    public List<MyUrl> getUrls() {
        return this.urls;
    }
}
