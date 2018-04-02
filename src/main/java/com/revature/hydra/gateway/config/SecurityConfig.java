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
// @EnableGlobalMethodSecurity(prePostEnabled = true)
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
                //.cors().and()//.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/swagger-ui.*", "/webjars/springfox-swagger-ui/**",
                        "/swagger-resources/**", "/api/*/v2/api-docs").permitAll()
                .anyRequest().authenticated();
    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(Arrays.asList("*"));
    //     configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    //     return source;
    // }

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
//
//  @Bean
//  public RedirectToAuthenticationPreFilter redirectFilter() {
//    return new RedirectToAuthenticationPreFilter();
//  }
//  

}