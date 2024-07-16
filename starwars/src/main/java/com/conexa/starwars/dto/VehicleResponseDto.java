package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class VehicleResponseDto {
	private ResultDto result;
    
    @Data
    public static class ResultDto {
        private VehicleDto properties;
    }
}
