package com.resultmanagementsystem.config;

import com.resultmanagementsystem.service.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic()
                .and()
                .csrf(c -> c.disable())
                .authorizeHttpRequests(a -> a.requestMatchers("/user/register").permitAll())
                .authorizeHttpRequests(a -> a. requestMatchers("/*").authenticated())
                .formLogin()
                .and()
                .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userRolesManagement(){
        return new CustomUserDetailsService();
    }

}
