package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class PersonResponseDto {
    private ResultDto result;
    
    @Data
    public static class ResultDto {
        private PersonDto properties;
    }
    
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
