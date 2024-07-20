package com.conexa.starwars.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.VehicleResponseDto.VehicleDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

import java.util.List;

@SpringBootTest
public class VehiclesServiceTest {

    @Autowired
    private StarWarsClient starWarsClient;

    @Autowired
    private VehiclesService vehiclesService;

    @Test
    public void testGetVehicles() {
        List<ResultDto> mockResponse = starWarsClient.getVehicles(1, 3).getResults();
        List<ResultDto> serviceResponse = vehiclesService.getVehicles(1, 3);
        assertEquals(mockResponse, serviceResponse);
    }

    @Test
    public void testGetVehicleById() {
        VehicleDto mockResponse = starWarsClient.getVehiclesById("4").getResult().getProperties();
        VehicleDto serviceResponse = vehiclesService.getVehiclesById("4");
        assertEquals(mockResponse, serviceResponse);
    }
}
