package com.example.openapi;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OpenapiApplication {

	@Autowired
	private SwaggerUiConfigParameters parameters;

	public static void main(String[] args) {
		SpringApplication.run(OpenapiApplication.class, args);
	}


}
