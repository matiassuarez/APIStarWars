package com.conexa.starwars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.FilmDto;
import com.conexa.starwars.dto.FilmResponseDto;
import com.conexa.starwars.dto.FilmResponseDto.FilmResultDto;
import java.util.List;

class FilmsServiceUnitTest {

    @Mock
    private StarWarsClient starWarsClient; 

    @InjectMocks
    private FilmService filmService; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testGetFilmById() {
        // Crear datos simulados
        FilmDto mockFilmDto = new FilmDto();
        mockFilmDto.setTitle("A New Hope");
        mockFilmDto.setEpisode_id("4");
        mockFilmDto.setOpening_crawl("It is a period of civil war ...");
        mockFilmDto.setDirector("George Lucas");
        mockFilmDto.setProducer("Gary Kurtz, Rick McCallum");
        mockFilmDto.setRelease_date("1977-05-25");
        mockFilmDto.setCharacters(List.of("https://www.swapi.tech/api/people/1/"));
        mockFilmDto.setPlanets(List.of("https://www.swapi.tech/api/planets/1/"));
        mockFilmDto.setStarships(List.of("https://www.swapi.tech/api/starships/2/"));
        mockFilmDto.setVehicles(List.of("https://www.swapi.tech/api/vehicles/4/"));
        mockFilmDto.setSpecies(List.of("https://www.swapi.tech/api/species/1/"));
        mockFilmDto.setCreated("2014-12-10T14:23:31.880000Z");
        mockFilmDto.setEdited("2014-12-12T11:24:39.858000Z");
        mockFilmDto.setUrl("https://www.swapi.tech/api/films/1/");

        FilmResultDto mockFilmResultDto = new FilmResultDto();
        mockFilmResultDto.setDescription("A classic space opera.");
        mockFilmResultDto.set_id("2");
        mockFilmResultDto.setUid("2");
        mockFilmResultDto.set__v(0);
        mockFilmResultDto.setProperties(mockFilmDto);

        // Crear un mock de la respuesta
        FilmResponseDto mockFilmResponseDto = new FilmResponseDto();
        mockFilmResponseDto.setMessage("Success");
        mockFilmResponseDto.setResult(mockFilmResultDto);

        // Configurar el mock para devolver mockFilmResponseDto
        when(starWarsClient.getFilmsById("1")).thenReturn(mockFilmResponseDto);

        // Método del servicio
        FilmResultDto serviceResponse = filmService.getFilmById("1");

        // Verificar la respuesta
        assertEquals(mockFilmResultDto, serviceResponse);
    }
}
