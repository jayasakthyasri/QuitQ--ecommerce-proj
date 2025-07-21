package com.springboot.Quitq_ecommerce_proj.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔓 Disable CSRF (for Postman/React testing)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // 🔓 Allow all requests
            )
            .httpBasic(Customizer.withDefaults()); // Or use .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
