package com.conexa.starwars.dto;

import java.util.List;

import com.conexa.starwars.dto.PersonResponseDto.PersonDto;

import lombok.Data;

@Data
public class PeopleNameResponseDto {
	private int total_records;
	private int total_pages;
    private String next;
    private String previous;
    private List<ResultNameDto> result;
    
    @Data
    public static class ResultNameDto {
        private PersonDto properties;
    }
}

