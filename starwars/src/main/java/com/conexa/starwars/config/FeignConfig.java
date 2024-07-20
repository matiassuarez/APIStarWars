package com.conexa.starwars.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.conexa.starwars.exception.ResourceNotFoundException;

/**
 * Configuración de FeignClient para el manejo de errores
 * de la API de Star Wars.
 * 
 */
@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            if (response.status() == HttpStatus.NOT_FOUND.value()) {
            	return new ResourceNotFoundException("Recurso no encontrado: " + methodKey);
			} 
            return new Exception("Error desconocido: " + methodKey);
        }
    }
}
