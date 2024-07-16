package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class StarshipResponseDto {
	private ResultDto result;
    
    @Data
    public static class ResultDto {
        private StarshipDto properties;
    }
    
}
