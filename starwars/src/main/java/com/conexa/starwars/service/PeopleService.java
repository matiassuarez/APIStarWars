package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PeopleNameResponseDto;
import com.conexa.starwars.dto.PersonResponseDto;
import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.PeopleNameResponseDto.ResultNameDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

/**
 * Servicio para gestionar las operaciones relacionadas a los recursos personas
 * en la API de Star Wars.
 * @author MSuarez
 */
@Service
public class PeopleService {
	
	@Autowired
    private StarWarsClient starWarsClient;
	
	/**
     * Obtiene una lista de personas.
     *
     * @param page numero de pagina de los resultados a obtener.
     * @param limit numero maximo de resultados por pagina.
     * @return{@link ResultDto} representa las personas.
     */
	public List<ResultDto> getPersonas(int page, int limit) {
    	ResponseDto peopleResponseDto =  starWarsClient.getPersonas(page, limit);
    	return peopleResponseDto.getResults();
    }
	
	 /**
     * Obtiene una persona por su nombre.
     *
     * @param name nombre de la persona a buscar.
     * @return {@link PersonDto} representa la persona.
     */	
    public PersonDto getPersonaByName(String name) {
    	PeopleNameResponseDto peopleNameResponseDto =  starWarsClient.getPersonaByName(name);
    	List<ResultNameDto> resultName = peopleNameResponseDto != null ? peopleNameResponseDto.getResult() : null;
    	
    	if (resultName != null && !resultName.isEmpty()) {
    	    return resultName.get(0).getProperties();
    	}        	
    	return null;
    }

    /**
     * Obtiene una persona por ID.
     *
     * @param id ID de la persona a buscar.
     * @return {@link PersonDto} representa la persona.
     */
    public PersonDto getPersonaById(String id) {
    	PersonResponseDto personResponseDto = starWarsClient.getPersonaById(id);
    	return personResponseDto.getResult().getProperties();
    }
}
