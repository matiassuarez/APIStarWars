package com.conexa.starwars.dto;

import lombok.Data;

/**
 * DTO para representar la respuesta de una solicitud de persona.
 */
@Data
public class PersonResponseDto {
    private ResultDto result;
    
    /**
     * DTO para representar el resultado de la solicitud de persona.
     */
    @Data
    public static class ResultDto {
        private PersonDto properties;
    }
    
    /**
     * DTO para representar las propiedades de una persona.
     */
    @Data
    public static class PersonDto {
        private String height;
        private String mass;
        private String hair_color;
        private String skin_color;
        private String eye_color;
        private String birth_year;
        private String gender;
        private String created;
        private String edited;
        private String name;
        private String homeworld;
        private String url;
    }
 
}
