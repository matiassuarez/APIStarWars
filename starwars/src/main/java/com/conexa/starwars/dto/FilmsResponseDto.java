package com.conexa.starwars.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO para representar la respuesta de una solicitud de una pelicula.
 */
@Data
public class FilmsResponseDto {
    private String message;
    private List<FilmsResultDto> result;
    
    /**
     * DTO para representar el resultado de la solicitud de una pelicula.
     */
    @Data
    public static class FilmsResultDto {
        private String description;
        private String _id;
        private String uid;
        private int __v;
        private FilmDto properties;
    }
}

