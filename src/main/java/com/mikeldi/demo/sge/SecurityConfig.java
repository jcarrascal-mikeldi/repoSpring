package com.mikeldi.demo.sge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desactiva protección CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // deja todo libre
            );
        return http.build();
    }
}
