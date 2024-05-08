package com.resultmanagementsystem.config;

import com.resultmanagementsystem.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(c -> c.disable())
                .authorizeHttpRequests(a -> a.requestMatchers("/student/create","/teacher/create").permitAll())
                .authorizeHttpRequests(a -> a. requestMatchers("/student/all").authenticated())
                .formLogin()
                .and()
                .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userRolesManagement(){
//        UserDetails teacher = User.withUsername("sushanshi")
//                .password(passwordEncoder().encode("123"))
//                .roles("TEACHER")
//                .build();
//        UserDetails student = User.withUsername("Ram")
//                .password(passwordEncoder().encode("Ram"))
//                .roles("STUDENT")
//                .build();

        return new CustomUserDetailsService();
    }

}
