package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.revature.caliber.filters.RedirectToAuthenticationPreFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@CrossOrigin
@EnableSwagger2
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
	
//  @Bean
//  public CorsFilter corsFilter() {
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    final CorsConfiguration config = new CorsConfiguration();
//    config.setAllowCredentials(true);
//    config.addAllowedOrigin("*");
//    config.addAllowedHeader("*");
//    config.addAllowedMethod("OPTIONS");
//    config.addAllowedMethod("HEAD");
//    config.addAllowedMethod("GET");
//    config.addAllowedMethod("PUT");
//    config.addAllowedMethod("POST");
//    config.addAllowedMethod("DELETE");
//    config.addAllowedMethod("PATCH");
//    source.registerCorsConfiguration("/**", config);
//    return new CorsFilter(source);
//  }

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.revature.caliber.controller"))              
          .paths(PathSelectors.any())                          
          .build();
    }
	
//  @Bean
//  public CorsFilter corsFilter() {
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    final CorsConfiguration config = new CorsConfiguration();
//    config.setAllowCredentials(true);
//    config.addAllowedOrigin("*");
//    config.addAllowedHeader("*");
//    config.addAllowedMethod("OPTIONS");
//    config.addAllowedMethod("HEAD");
//    config.addAllowedMethod("GET");
//    config.addAllowedMethod("PUT");
//    config.addAllowedMethod("POST");
//    config.addAllowedMethod("DELETE");
//    config.addAllowedMethod("PATCH");
//    source.registerCorsConfiguration("/**", config);
//    return new CorsFilter(source);
//  }

  @Bean
  public RedirectToAuthenticationPreFilter redirectFilter() {
    return new RedirectToAuthenticationPreFilter();
  }
  
}
