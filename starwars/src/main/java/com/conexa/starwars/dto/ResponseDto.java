package com.conexa.starwars.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDto {
	private int total_records;
	private int total_pages;
    private String next;
    private String previous;
    private List<ResultDto> results;
    
    @Data
    public static class ResultDto {
    	private String uid;
        private String name;
        private String url;
    }
}
