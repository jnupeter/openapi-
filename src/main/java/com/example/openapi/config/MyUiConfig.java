package com.example.openapi.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
@Primary
public class MyUiConfig extends SwaggerUiConfigProperties {

    @Value("${my.urlStr}")
    private String urlStr;

    @Override
    public Set<SwaggerUrl> getUrls() {
        Set<SwaggerUrl> urls = super.getUrls();
        if(urls != null) {
            List<SwaggerUrl> urlsFromConfig = readFromConfig(urlStr);
            urls.add(new SwaggerUrl("self-service", "../v3/api-docs"));
            for(SwaggerUrl url : urlsFromConfig) {
                urls.add(url);
            }
        }
        return urls;
    }

    private List<SwaggerUrl> readFromConfig(String urlStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(urlStr, new TypeReference<List<SwaggerUrl>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
