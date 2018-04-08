package com.revature.hydra.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Primary
@EnableAutoConfiguration
@EnableSwagger2
public class DocumentationController implements SwaggerResourcesProvider{

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.revature.hydra.gateway.controller"))              
          .paths(PathSelectors.any())                          
          .build();
    }

	@Override
    public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();

		// A bit confusing here: the 'v2' below refers to Swagger version 2!

		resources.add(swaggerResource("", "/api/v2/api-docs", "2.0"));

		// resources.add(swaggerResource("address", "/api/address/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("batch", "/api/batch/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("curriculum", "/api/curriculum/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("skills", "/api/skills/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("trainer", "/api/trainer/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("unavailable", "/api/unavailable/v2/api-docs", "2.0"));

		// resources.add(swaggerResource("trainee", "/api/trainee/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("types", "/api/types/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("assessment", "/api/assessment/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("grade", "/api/grade/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("pdf", "/api/pdf/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("salesforce", "/api/salesforce/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("note", "/api/note/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("category", "/api/category/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("panel", "/api/panel/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("reporting", "/api/reporting/v2/api-docs", "2.0"));

		return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
	}

}
