package com.morinaga.christianportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register/**",
                                "/",
                                "/static/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
//                                "**/favicon.ico",
                                "/api/member/register",
                                "/api/login",
                                "/api/categories/add",
                                "/api/contents/add",
                                "/api/members/add",
                                "/api/members",
                                "/api/members/id",
                                "/api/comments/add"
                        ).permitAll() // Allow access to public and static resources
                        .requestMatchers("/getAll/**",
                                "/save/**",
                                "/add/**",
                                "/update/**",
                                "/delete/**",
                                "/api/**"
                        ).hasRole("ADMIN") // Secure specific API endpoints for ADMIN role
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/api/login") // Specify custom login page
                        .loginProcessingUrl("/login") // Login form submission URL
                        .defaultSuccessUrl("/") // Redirect to homepage on success
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout")) // Logout URL
                        .logoutSuccessUrl("/login?logout") // Redirect after logout
                        .invalidateHttpSession(true) // Invalidate session on logout
                        .deleteCookies("JSESSIONID") // Delete session cookie
                        .permitAll()
                )
                .cors(withDefaults()); // Enable CORS with default settings

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173")); // Allow specific origin(s)
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

