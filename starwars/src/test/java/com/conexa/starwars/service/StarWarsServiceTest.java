package com.conexa.starwars.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.dto.VehicleResponseDto.VehicleDto;
import com.conexa.starwars.dto.StarshipResponseDto.StarshipDto;
import com.conexa.starwars.dto.FilmResponseDto.FilmResultDto;
import com.conexa.starwars.dto.FilmsResponseDto.FilmsResultDto;

import java.util.List;

@SpringBootTest
public class StarWarsServiceTest {

    @Autowired
    private StarWarsClient starWarsClient;

    @Autowired
    private PeopleService peopleService;
    
    @Autowired
    private VehiclesService vehiclesService;
    
    @Autowired
    private StarshipService starshipService;
    
    @Autowired
    private FilmService filmService;

	@Test
	public void testGetPeople() {
		// Mock response Client
        List<ResultDto> mockResponse = starWarsClient.getPersonas(1, 3).getResults();
        // Método service
	    List<ResultDto> serviceResponse = peopleService.getPersonas(1, 3);
        // Verificar la respuesta
		assertEquals(mockResponse, serviceResponse);
	}
	
	@Test 
	public void testGetPersonById() { 
		// Mock response Client
		PersonDto mockResponse = starWarsClient.getPersonaById("2").getResult().getProperties();
        // Método service
        PersonDto serviceResponse = peopleService.getPersonaById("2");
        // Verificar la respuesta
        assertEquals(mockResponse, serviceResponse);
	}
	
	@Test
	public void testGetVehicles() {
		// Mock response Client
		List<ResultDto> mockResponse = starWarsClient.getVehicles(1, 3).getResults();
        // Método service
	    List<ResultDto> serviceResponse = vehiclesService.getVehicles(1, 3);
        // Verificar la respuesta
		assertEquals(mockResponse, serviceResponse);
	}
	
	@Test 
	public void testGetVehicleById() { 
		// Mock response Client
		VehicleDto mockResponse = starWarsClient.getVehiclesById("4").getResult().getProperties();
        // Método service
		VehicleDto serviceResponse = vehiclesService.getVehiclesById("4");
        // Verificar la respuesta
        assertEquals(mockResponse, serviceResponse);
	}
	
	@Test
	public void testGetStarship() {
		// Mock response Client
		List<ResultDto> mockResponse = starWarsClient.getStarships(1, 3).getResults();
        // Método service
	    List<ResultDto> serviceResponse = starshipService.getStarships(1, 3);
        // Verificar la respuesta
		assertEquals(mockResponse, serviceResponse);
	}
	
	@Test 
	public void testGetStarshipById() { 
		// Mock response Client
		StarshipDto mockResponse = starWarsClient.getStarshipById("2").getResult().getProperties();
        // Método service
		StarshipDto serviceResponse = starshipService.getStarshipById("2");
        // Verificar la respuesta
        assertEquals(mockResponse, serviceResponse);
	}
	
	@Test
	public void testGetFilms() {
		// Mock response Client
		List<FilmsResultDto> mockResponse = starWarsClient.getFilms(1, 3).getResult();
        // Método service
	    List<FilmsResultDto> serviceResponse = filmService.getFilms(1, 3);
        // Verificar la respuesta
		assertEquals(mockResponse, serviceResponse);
	}
	
	@Test 
	public void testGetFilmById() { 
		// Mock response Client
		FilmResultDto mockResponse = starWarsClient.getFilmsById("2").getResult();
        // Método service
		FilmResultDto serviceResponse = filmService.getFilmById("2");
        // Verificar la respuesta
        assertEquals(mockResponse, serviceResponse);
	}
}