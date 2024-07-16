package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

@Data
public class VehicleResponseDto {
	private ResultDto result;
    
    @Data
    public static class ResultDto {
        private VehicleDto properties;
    }
    
    @Data
    public static class VehicleDto {
    	private String name;
        private String model;
        private String vehicle_class;
        private String manufacturer;
        private String length;
        private String cost_in_credits;
        private String crew;
        private String passengers;
        private String max_atmosphering_speed;
        private String cargo_capacity;
        private String consumables;
        private List<String> films;
        private List<String> pilots;
        private String url;
        private String created;
        private String edited;
    }
}
