package com.conexa.starwars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PersonResponseDto;
import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.PersonResponseDto.ResultDto;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PeopleServiceUnitTest {

    @Mock
    private StarWarsClient starWarsClient; 

    @InjectMocks
    private PeopleService peopleService; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testGetPersonById() {
    	// Crear objeto PersonDto con datos simulados
        PersonDto mockPerson = new PersonDto();
        mockPerson.setHeight("172");
        mockPerson.setMass("77");
        mockPerson.setHair_color("blond");
        mockPerson.setSkin_color("fair");
        mockPerson.setEye_color("blue");
        mockPerson.setBirth_year("19BBY");
        mockPerson.setGender("male");
        mockPerson.setCreated("2024-07-20T12:00:00Z");
        mockPerson.setEdited("2024-07-20T12:00:00Z");
        mockPerson.setName("Luke Skywalker");
        mockPerson.setHomeworld("Tatooine");
        mockPerson.setUrl("http://swapi.dev/api/people/1/");

        ResultDto mockResult = new ResultDto();
        mockResult.setProperties(mockPerson);

        PersonResponseDto mockResponse = new PersonResponseDto();
        mockResponse.setResult(mockResult);

        // Configuración del mock
        when(starWarsClient.getPersonaById("1")).thenReturn(mockResponse);

        // Método service
        PersonDto serviceResponse = peopleService.getPersonaById("1");

        // Verificacion respuesta
        assertEquals(mockPerson, serviceResponse);
    }
}

