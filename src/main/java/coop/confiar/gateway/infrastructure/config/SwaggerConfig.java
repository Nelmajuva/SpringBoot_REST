package coop.confiar.gateway.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        var infoObject = new Info().title("Gateway API").version("1.0.0").description("Documentation of API with REST and SQL.");

        return new OpenAPI().info(infoObject);
    }
}
