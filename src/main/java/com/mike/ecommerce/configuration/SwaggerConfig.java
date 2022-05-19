package com.mike.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.ws.rs.core.SecurityContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mike.ecommerce"))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

//    private SecurityContext securityContext() {
////        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Mike-eCommerce",
                "Ecommerce app",
                "1.0",
                "Terms of service for retail",
                new Contact("BookXChange team", "www.mike-ecommerce.gov", "best-shop@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

}
