package org.example.springbootproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF and configure exception handling and authorization
        http.csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(authz ->
                        authz
                                .anyRequest().permitAll()  // Allow open access to auth endpoints
                );

        return http.build();
    }
}
