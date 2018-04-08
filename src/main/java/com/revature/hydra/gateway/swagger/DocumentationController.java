package com.revature.hydra.gateway.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/***
 * DocumentationController is responsible for establishing Swagger
 * documentation. Swagger ui can be accessed at:
 * http://localhost:8800/swagger-ui.html
 * 
 * @author Unknown
 */

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("batches", "/api/v2/batches/v2/api-docs", "2.0"));
		resources.add(swaggerResource("curriculums", "/api/v2/curriculums/v2/api-docs", "2.0"));
		resources.add(swaggerResource("topics", "/api/v2/topics/v2/api-docs", "2.0"));
		resources.add(swaggerResource("users", "/api/v2/users/v2/api-docs", "2.0"));

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