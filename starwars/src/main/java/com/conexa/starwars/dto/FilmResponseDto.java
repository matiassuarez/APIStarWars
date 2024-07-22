package com.conexa.starwars.dto;

import lombok.Data;

/**
 * DTO para representar la respuesta de una solicitud de una lista de peliculas.
 */
@Data
public class FilmResponseDto {
	private String message;
    private FilmResultDto result;
    
    /**
     * DTO para representar el resultado de la solicitud de una lista de peliculas.
     */
    @Data
    public static class FilmResultDto {
        private String description;
        private String _id;
        private String uid;
        private int __v;
        private FilmDto properties;
    }
}
