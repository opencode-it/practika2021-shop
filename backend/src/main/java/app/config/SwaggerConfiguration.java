package app.config;

import app.components.CustomPathProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    // Каким типы авторизации поддерживает сервис(Вам пока можно без него)
    private SecurityScheme jwtScheme() {
        return HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name("JWT")
                .build();
    }
    // Каким url добавлять возможность авторизации(сейчас всем)
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(defaultAuth()))
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();
    }
    // Конфигурация авторизаций
    private SecurityReference defaultAuth() {
        return SecurityReference.builder()
                .scopes(new AuthorizationScope[0])
                .reference("JWT")
                .build();
    }
    @Bean
    public Docket api(CustomPathProvider customPathProvider) {
        return new Docket(DocumentationType.OAS_30)
                .pathProvider(customPathProvider)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(jwtScheme()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API",
                "APi для работы",
                "0.1",
                "",
                new Contact("", "", ""),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}