package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.FilmResponseDto;
import com.conexa.starwars.dto.FilmResponseDto.FilmResultDto;
import com.conexa.starwars.dto.FilmsResponseDto.FilmsResultDto;
import com.conexa.starwars.dto.FilmsResponseDto;

@Service
public class FilmService {
	@Autowired
    private StarWarsClient starWarsClient;
	
	public List<FilmsResultDto> getFilms(int page, int limit) {
		FilmsResponseDto filmsResponseDto = starWarsClient.getFilms(page, limit);
		return filmsResponseDto.getResult();
    }

    public FilmResultDto getFilmById(String id) {
    	FilmResponseDto filmResponseDto = starWarsClient.getFilmsById(id);
        return filmResponseDto.getResult();
    }
}
