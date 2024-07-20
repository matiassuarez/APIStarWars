package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.VehicleResponseDto;
import com.conexa.starwars.dto.VehicleResponseDto.VehicleDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

/**
 * Servicio para gestionar las operaciones relacionadas a los recursos vehiculos
 * en la API de Star Wars..
 * @author MSuarez
 */
@Service
public class VehiclesService {
	
	@Autowired
    private StarWarsClient starWarsClient;
	
	/**
     * Obtiene una lista de vehiculos.
     *
     * @param page numero de pagina de los resultados a obtener.
     * @param limit numero maximo de resultados por pagina.
     * @return {@link ResultDto} representa los vehiculos.
     */
	public List<ResultDto> getVehicles(int page, int limit) {
		ResponseDto vehiclesResponseDto = starWarsClient.getVehicles(page, limit);
		return vehiclesResponseDto.getResults();
    }

	/**
     * Obtiene un vehículo por su identificador desde la API de Star Wars.
     *
     * @param id ID del vehiculo a buscar.
     * @return {@link VehicleDto} representa el vehiculo.
     */
    public VehicleDto getVehiclesById(String id) {
    	VehicleResponseDto vehicleResponseDto = starWarsClient.getVehiclesById(id);
        return vehicleResponseDto.getResult().getProperties();
    }
}
