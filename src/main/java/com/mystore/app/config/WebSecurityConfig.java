package com.mystore.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/**").permitAll() // allow public routes like /auth/login
                .anyRequest().authenticated()            // secure everything else
            )
            .httpBasic(); // or .formLogin(), or JWT filter if you're using JWT

        return http.build();
    }
}
