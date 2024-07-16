package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.FilmDto;
import com.conexa.starwars.dto.FilmResponseDto;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

@Service
public class FilmService {
	@Autowired
    private StarWarsClient starWarsClient;
	
	public List<ResultDto> getFilms(int page, int limit) {
		ResponseDto filmsResponseDto = starWarsClient.getFilms(page, limit);
		return filmsResponseDto.getResults();
    }

    public FilmDto getFilmById(String id) {
    	FilmResponseDto filmResponseDto = starWarsClient.getFilmsById(id);
        return filmResponseDto.getResult().getProperties();
    }
}
