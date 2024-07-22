package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

/**
 * DTO para representar los detalles de una pelicula de Star Wars.
 */
@Data
public class FilmDto {
    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;
}