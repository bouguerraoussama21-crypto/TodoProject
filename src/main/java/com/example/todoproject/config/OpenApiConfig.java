package com.example.todoproject.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI todoOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("ToDo Project API")
                        .description("API pour gérer les tâches")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")) )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://example.com"));
    }
}
