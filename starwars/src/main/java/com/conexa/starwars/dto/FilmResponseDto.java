package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class FilmResponseDto {
	private String message;
    private FilmResultDto result;
    
    @Data
    public static class FilmResultDto {
        private String description;
        private String _id;
        private String uid;
        private int __v;
        private FilmDto properties;
    }
}
