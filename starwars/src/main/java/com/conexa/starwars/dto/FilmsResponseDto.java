package com.conexa.starwars.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmsResponseDto {
    private String message;
    private List<FilmsResultDto> result;
    
    @Data
    public static class FilmsResultDto {
        private String description;
        private String _id;
        private String uid;
        private int __v;
        private FilmDto properties;
    }
}

