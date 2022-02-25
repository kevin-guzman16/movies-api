package com.movies.movies.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBL_URL = {
        "/api/movies",
        "/api/movies/*",
        "/api/user"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests().antMatchers(PUBL_URL).permitAll()
            .anyRequest().authenticated();
    }
    
}
