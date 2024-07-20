package com.conexa.starwars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.VehicleResponseDto;
import com.conexa.starwars.dto.VehicleResponseDto.VehicleDto;
import com.conexa.starwars.dto.VehicleResponseDto.ResultDto;
import java.util.ArrayList;
import java.util.List;

class VehiclesServiceUnitTest {

    @Mock
    private StarWarsClient starWarsClient; // Mock del cliente

    @InjectMocks
    private VehiclesService vehiclesService; // Servicio bajo prueba

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testGetVehicleById() {
        // Crear datos simulados
        VehicleDto mockVehicleDto = new VehicleDto();
        mockVehicleDto.setName("Sand Crawler");
        mockVehicleDto.setModel("Digger Crawler");
        mockVehicleDto.setVehicle_class("wheeled");
        mockVehicleDto.setManufacturer("Corellia Mining Corporation");
        mockVehicleDto.setLength("36.8");
        mockVehicleDto.setCost_in_credits("150000");
        mockVehicleDto.setCrew("46");
        mockVehicleDto.setPassengers("30");
        mockVehicleDto.setMax_atmosphering_speed("30");
        mockVehicleDto.setCargo_capacity("50000");
        mockVehicleDto.setConsumables("2 months");
        mockVehicleDto.setFilms(List.of("https://www.swapi.tech/api/films/1/"));
        mockVehicleDto.setPilots(new ArrayList<>());
        mockVehicleDto.setUrl("https://www.swapi.tech/api/vehicles/4/");
        mockVehicleDto.setCreated("2014-12-10T15:36:25.724000Z");
        mockVehicleDto.setEdited("2014-12-10T15:36:25.724000Z");

        // Crear un mock de la respuesta
        ResultDto mockResultDto = new ResultDto();
        mockResultDto.setProperties(mockVehicleDto);
        
        // Crear un mock de la respuesta
        VehicleResponseDto mockResponseDto = new VehicleResponseDto();
        mockResponseDto.setResult(mockResultDto);

        // Configurar el mock para devolver mockResultDto
        when(starWarsClient.getVehiclesById("4")).thenReturn(mockResponseDto);

        // Método del servicio
        VehicleDto serviceResponse = vehiclesService.getVehiclesById("4");

        // Verificar la respuesta
        assertEquals(mockVehicleDto, serviceResponse);
    }
}

