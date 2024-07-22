package com.conexa.starwars.dto;

import java.util.List;

import com.conexa.starwars.dto.PersonResponseDto.PersonDto;

import lombok.Data;

/**
 * DTO para representar la respuesta de una solicitud de personas filtradas por nombre.
 */
@Data
public class PeopleNameResponseDto {
	private int total_records;
	private int total_pages;
    private String next;
    private String previous;
    private List<ResultNameDto> result;
    
    /**
     * DTO para representar el resultado de la solicitud de personas filtradas por nombre.
     */
    @Data
    public static class ResultNameDto {
        private PersonDto properties;
    }
}

