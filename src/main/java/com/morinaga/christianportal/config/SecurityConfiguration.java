package com.morinaga.christianportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()  //Enable cors
                .and()
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/member/register"
                                        ,"/api/login"
                                        ,"/api/categories/add" ,
                                        "/api/contents/add",
                                         "api/member/",
                                         "api/comments/add"

                        ).permitAll()//Allow access to register endpoint
                        .requestMatchers("/api/**").authenticated()//Secure other API  endpoints
                        .anyRequest().permitAll()
                )

                .httpBasic(); //Enable basic authentication
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

