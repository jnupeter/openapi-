package com.example.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@OpenAPIDefinition(servers = {
        @Server(url = "http://localhost:9888/abc"),
        @Server(url = "/mongo"),
        @Server(url = "/")
})
public class OpenapiApplication {

    @Autowired
    private SwaggerUiConfigParameters parameters;

    public static void main(String[] args) {
        SpringApplication.run(OpenapiApplication.class, args);
    }


}
