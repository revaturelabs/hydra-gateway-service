package com.revature.caliber.swagger;

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
		resources.add(swaggerResource("trainer", "/trainer/v2/api-docs", "2.0"));
		resources.add(swaggerResource("trainee", "/trainee/v2/api-docs", "2.0"));
		resources.add(swaggerResource("types", "/types/v2/api-docs", "2.0"));
		resources.add(swaggerResource("assessment", "/assessment/v2/api-docs", "2.0"));
		resources.add(swaggerResource("grade", "/grade/v2/api-docs", "2.0"));
		resources.add(swaggerResource("batch", "/batch/v2/api-docs", "2.0"));
		resources.add(swaggerResource("address", "/address/v2/api-docs", "2.0"));
		resources.add(swaggerResource("pdf", "/pdf/v2/api-docs", "2.0"));
		resources.add(swaggerResource("salesforce", "/salesforce/v2/api-docs", "2.0"));
		resources.add(swaggerResource("note", "/note/v2/api-docs", "2.0"));
		resources.add(swaggerResource("category", "/category/v2/api-docs", "2.0"));
		resources.add(swaggerResource("panel", "/panel/v2/api-docs", "2.0"));
		resources.add(swaggerResource("reporting", "/reporting/v2/api-docs", "2.0"));
		

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
