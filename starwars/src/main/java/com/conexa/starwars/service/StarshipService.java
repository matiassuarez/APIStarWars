package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.StarshipDto;
import com.conexa.starwars.dto.StarshipResponseDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

@Service
public class StarshipService {
	@Autowired
    private StarWarsClient starWarsClient;
	
	public List<ResultDto> getStarships(int page, int limit) {
		ResponseDto starshipsResponseDto = starWarsClient.getStarships(page, limit);
		return starshipsResponseDto.getResults();
    }

    public StarshipDto getStarshipById(String id) {
    	StarshipResponseDto starshipResponseDto = starWarsClient.getStarshipById(id);
        return starshipResponseDto.getResult().getProperties();
    }
}
