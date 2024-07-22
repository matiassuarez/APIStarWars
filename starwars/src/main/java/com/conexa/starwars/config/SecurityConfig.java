package com.conexa.starwars.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
     * Configuracion de seguridad.
     * 
     * @param http HttpSecurity configura la seguridad basada en web
     * @throws Exception atrapa error durante la configuracion de seguridad
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/api/starwars/**").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

}


