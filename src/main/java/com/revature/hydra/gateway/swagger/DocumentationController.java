package com.revature.hydra.gateway.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider{
	
	@Override
    public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		// resources.add(swaggerResource("trainer", "/api/trainer/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("trainee", "/api/trainee/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("types", "/api/types/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("assessment", "/api/assessment/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("grade", "/api/grade/v2/api-docs", "2.0"));
		resources.add(swaggerResource("batch", "/api/batch/v0/api-docs", "2.0"));
		resources.add(swaggerResource("address", "/api/address/v0/api-docs", "2.0"));
		// resources.add(swaggerResource("pdf", "/api/pdf/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("salesforce", "/api/salesforce/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("note", "/api/note/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("category", "/api/category/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("panel", "/api/panel/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("reporting", "/api/reporting/v2/api-docs", "2.0"));
		resources.add(swaggerResource("curriculum", "/api/curriculum/v0/api-docs", "2.0"));
		

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
