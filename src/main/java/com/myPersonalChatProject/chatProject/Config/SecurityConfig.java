package com.myPersonalChatProject.chatProject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/signup", "/submitSignUp", "/login", "/css/**", "/js/**").permitAll() // signup & static files accessible
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")     // customlogin page
                        .loginProcessingUrl("/login") // where Spring Security listens for POST credentials
                        .defaultSuccessUrl("/home", true) // redirect after login
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
