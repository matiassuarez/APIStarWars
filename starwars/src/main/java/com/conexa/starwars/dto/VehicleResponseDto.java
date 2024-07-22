package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

/**
 * DTO para representar la respuesta de una solicitud de vehiculo.
 */
@Data
public class VehicleResponseDto {
	private ResultDto result;
    
	/**
     * DTO para representar el resultado de la solicitud de vehiculo.
     */
    @Data
    public static class ResultDto {
        private VehicleDto properties;
    }
    
    /**
     * DTO para representar las propiedades de un vehiculo.
     */
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
