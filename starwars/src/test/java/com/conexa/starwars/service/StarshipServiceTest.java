package com.conexa.starwars.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.StarshipResponseDto.StarshipDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

import java.util.List;

@SpringBootTest
public class StarshipServiceTest {

    @Autowired
    private StarWarsClient starWarsClient;

    @Autowired
    private StarshipService starshipService;

    @Test
    public void testGetStarship() {
        List<ResultDto> mockResponse = starWarsClient.getStarships(1, 3).getResults();
        List<ResultDto> serviceResponse = starshipService.getStarships(1, 3);
        assertEquals(mockResponse, serviceResponse);
    }

    @Test
    public void testGetStarshipById() {
        StarshipDto mockResponse = starWarsClient.getStarshipById("2").getResult().getProperties();
        StarshipDto serviceResponse = starshipService.getStarshipById("2");
        assertEquals(mockResponse, serviceResponse);
    }
}
