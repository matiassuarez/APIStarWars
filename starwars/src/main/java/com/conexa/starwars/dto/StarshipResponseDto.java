package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

@Data
public class StarshipResponseDto {
	private ResultDto result;
    
    @Data
    public static class ResultDto {
        private StarshipDto properties;
    }
    
    @Data
    public static class StarshipDto {
        private String name;
        private String model;
        private String starship_class;
        private String manufacturer;
        private String cost_in_credits;
        private String length;
        private String crew;
        private String passengers;
        private String max_atmosphering_speed;
        private String hyperdrive_rating;
        private String MGLT;
        private String cargo_capacity;
        private String consumables;
        private List<String> films;
        private List<String> pilots;
        private String url;
        private String created;
        private String edited;
    }
    
}
