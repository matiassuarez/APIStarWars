package com.conexa.starwars.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.FilmResponseDto.FilmResultDto;
import com.conexa.starwars.dto.FilmsResponseDto.FilmsResultDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class FilmsServiceTest {

    @Autowired
    private StarWarsClient starWarsClient;

    @Autowired
    private FilmService filmService;

    @Test
    public void testGetFilms() {
        List<FilmsResultDto> mockResponse = starWarsClient.getFilms(1, 3).getResult();
        List<FilmsResultDto> serviceResponse = filmService.getFilms(1, 3);
        assertEquals(mockResponse, serviceResponse);
    }

    @Test 
    public void testGetFilmById() { 
        FilmResultDto mockResponse = starWarsClient.getFilmsById("2").getResult();
        FilmResultDto serviceResponse = filmService.getFilmById("2");
        assertEquals(mockResponse, serviceResponse);
    }
}
