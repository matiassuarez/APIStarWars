package com.conexa.starwars.dto;

import lombok.Data;

@Data
public class PersonResponseDto {
    private ResultDto result;
    
    @Data
    public static class ResultDto {
        private PersonDto properties;
    }
 
}
