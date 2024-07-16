package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.StarshipDto;
import com.conexa.starwars.dto.StarshipResponseDto;
import com.conexa.starwars.dto.VehicleDto;
import com.conexa.starwars.dto.VehicleResponseDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

@Service
public class VehiclesService {
	@Autowired
    private StarWarsClient starWarsClient;
	
	public List<ResultDto> getVehicles(int page, int limit) {
		ResponseDto vehiclesResponseDto = starWarsClient.getVehicles(page, limit);
		return vehiclesResponseDto.getResults();
    }

    public VehicleDto getVehiclesById(String id) {
    	VehicleResponseDto vehicleResponseDto = starWarsClient.getVehiclesById(id);
        return vehicleResponseDto.getResult().getProperties();
    }
}
