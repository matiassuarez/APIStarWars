package com.conexa.starwars.dto;

import lombok.Data;
import java.util.List;

@Data
public class StarshipDto {
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
