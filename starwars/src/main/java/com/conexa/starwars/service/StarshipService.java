package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.StarshipResponseDto;
import com.conexa.starwars.dto.StarshipResponseDto.StarshipDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

/**
 * Servicio para gestionar las operaciones relacionadas a los recursos naves espaciales
 * en la API de Star Wars.
 * @author MSuarez
 */
@Service
public class StarshipService {
	
	@Autowired
    private StarWarsClient starWarsClient;
	
	/**
     * Obtiene una lista de naves espaciales.
     *
     * @param page numero de pagina de los resultados a obtener.
     * @param limit numero maximo de resultados por pagina.
     * @return {@link ResultDto} representa las naves espaciales.
     */
	public List<ResultDto> getStarships(int page, int limit) {
		ResponseDto starshipsResponseDto = starWarsClient.getStarships(page, limit);
		return starshipsResponseDto.getResults();
    }

	/**
     * Obtiene una nave espacial por ID.
     *
     * @param id ID de la nave especial a buscar.
     * @return {@link StarshipDto} representa la nave espacial.
     */
    public StarshipDto getStarshipById(String id) {
    	StarshipResponseDto starshipResponseDto = starWarsClient.getStarshipById(id);
        return starshipResponseDto.getResult().getProperties();
    }
}
