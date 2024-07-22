package com.conexa.starwars.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PersonResponseDto;
import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.dto.ResponseDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    private StarWarsClient starWarsClient;

    @Autowired
    private PeopleService peopleService;

    @Test
	public void testGetPeople() {
        List<ResultDto> mockResponse = starWarsClient.getPersonas(1, 3).getResults();
	    List<ResultDto> serviceResponse = peopleService.getPersonas(1, 3);
	    assertEquals(mockResponse, serviceResponse);
	}
	
	@Test 
	public void testGetPersonById() { 
		PersonDto mockResponse = starWarsClient.getPersonaById("2").getResult().getProperties();
        PersonDto serviceResponse = peopleService.getPersonaById("2");
        assertEquals(mockResponse, serviceResponse);
	}
}
