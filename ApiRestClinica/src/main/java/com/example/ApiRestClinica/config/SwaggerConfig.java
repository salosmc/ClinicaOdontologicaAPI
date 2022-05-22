package com.example.ApiRestClinica.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import io.swagger.v3.oas.models.Components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Clinica dental API",
                                version = "v1",
                                description = "Es una API que permite la gestion de turnos en una clinica odontologica \n"
                                        +"Base url: ",
                                contact = @Contact(name="Salomón Morales",
                                                    url= "https://www.linkedin.com/in/salosmc/"
                                        )
                                )
                        )
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
    /*
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Clinica dental API")
                        .description("Es una API que permite la gestion de turnos en una clinica odontologica\n"
                        +"Base url: ")
                        .contact(new Contact()
                                .name("Salomón Morales")
                                .url("https://www.linkedin.com/in/salosmc/")

                        )
                );
    }
*/
}
