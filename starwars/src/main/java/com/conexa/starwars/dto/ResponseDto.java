package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

/**
 * DTO para representar una respuesta generica con paginacion.
 */
@Data
public class ResponseDto {
	private int total_records;
	private int total_pages;
    private String next;
    private String previous;
    private List<ResultDto> results;
    
    /**
     * DTO para representar un resultado en la respuesta paginada.
     */
    @Data
    public static class ResultDto {
    	private String uid;
        private String name;
        private String url;
    }
}
