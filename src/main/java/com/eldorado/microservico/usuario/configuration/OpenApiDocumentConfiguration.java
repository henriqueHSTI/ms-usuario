package com.eldorado.microservico.usuario.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocumentConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("MS-Usuário")
                .description("MS - Usuario")
                .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("ms-usuario")
                .pathsToMatch("**/user/**")
                .build();
    }
}
