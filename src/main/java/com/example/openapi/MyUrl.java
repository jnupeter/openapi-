package com.example.openapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyUrl {
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;

    public MyUrl() {

    }

    @JsonCreator
    public MyUrl(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
