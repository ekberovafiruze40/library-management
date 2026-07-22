package az.edu.library.library_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI libraryOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Library Mnagement API")
                        .description("Library Management System REST API documentation for internship project")
                        .version("v1.0.0"));
    }
}
