package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class FilmResponseDto {
	private ResultDto result;
    
    @Data
    public static class ResultDto {
        private FilmDto properties;
    }
}
