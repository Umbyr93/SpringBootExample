package io.github.urusso.springbootexample.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private final String version;
    private final String title;
    private final String description;

    public SwaggerConfig(@Value("${swagger.version}") String version, @Value("${swagger.title}") String title,
                         @Value("${swagger.description}") String description) {
        this.title = title;
        this.version = version;
        this.description = description;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description));
    }
}
