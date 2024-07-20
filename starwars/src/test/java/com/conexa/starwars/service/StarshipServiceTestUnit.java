package com.conexa.starwars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.StarshipResponseDto.StarshipDto;
import com.conexa.starwars.dto.StarshipResponseDto;
import com.conexa.starwars.dto.StarshipResponseDto.ResultDto;
import java.util.ArrayList;
import java.util.List;

public class StarshipServiceTestUnit {

    @Mock
    private StarWarsClient starWarsClient; // Mock del cliente

    @InjectMocks
    private StarshipService starshipService; // Servicio bajo prueba

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }
    
	@Test
    void testGetStarshipById() {
        // Crear datos simulados
        StarshipDto mockStarshipDto = new StarshipDto();
        mockStarshipDto.setName("Death Star");
        mockStarshipDto.setModel("DS-1 Orbital Battle Station");
        mockStarshipDto.setStarship_class("Deep Space Mobile Battlestation");
        mockStarshipDto.setManufacturer("Imperial Department of Military Research, Sienar Fleet Systems");
        mockStarshipDto.setCost_in_credits("1000000000000");
        mockStarshipDto.setLength("120000");
        mockStarshipDto.setCrew("342953");
        mockStarshipDto.setPassengers("843342");
        mockStarshipDto.setMax_atmosphering_speed("n/a");
        mockStarshipDto.setHyperdrive_rating("4.0");
        mockStarshipDto.setMGLT("10 MGLT");
        mockStarshipDto.setCargo_capacity("1000000000000");
        mockStarshipDto.setConsumables("3 years");
        mockStarshipDto.setFilms(List.of("https://www.swapi.tech/api/films/1/"));
        mockStarshipDto.setPilots(new ArrayList<>());
        mockStarshipDto.setUrl("https://www.swapi.tech/api/starships/9/");
        mockStarshipDto.setCreated("2014-12-10T16:36:50.509000Z");
        mockStarshipDto.setEdited("2014-12-10T16:36:50.509000Z");

        ResultDto mockResultDto = new ResultDto();
        mockResultDto.setProperties(mockStarshipDto);
        
        StarshipResponseDto mockResponse = new StarshipResponseDto();
        mockResponse.setResult(mockResultDto);

        // Configurar el mock para devolver mockResultDto
        when(starWarsClient.getStarshipById("9")).thenReturn(mockResponse);

        // Método del servicio
        StarshipDto serviceResponse = starshipService.getStarshipById("9");

        // Verificar la respuesta
        assertEquals(mockStarshipDto, serviceResponse);
    }
}
