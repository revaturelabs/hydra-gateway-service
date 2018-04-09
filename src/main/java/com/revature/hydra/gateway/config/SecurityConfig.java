package com.revature.hydra.gateway.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value(value = "${AUTH0_APIAUDIENCE}")
    private String apiAudience;
    @Value(value = "${AUTH0_ISSUER}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
            .forRS256(apiAudience, issuer)
            .configure(http)
            .headers().disable()
            .authorizeRequests()
            .antMatchers(
                HttpMethod.GET,
                "/swagger-ui.*",
                "/webjars/springfox-swagger-ui/**",
                "/swagger-resources/**",
                "/api/v2/api-docs",
                "/v2/api-docs"
            ).permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .anyRequest().authenticated();
    }

}
