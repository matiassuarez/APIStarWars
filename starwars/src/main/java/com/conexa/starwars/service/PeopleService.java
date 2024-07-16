package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PeopleDto;
import com.conexa.starwars.dto.PeopleNameResponseDto;
import com.conexa.starwars.dto.PersonDto;
import com.conexa.starwars.dto.PersonResponseDto;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.PeopleNameResponseDto.ResultNameDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

@Service
public class PeopleService {
	
	@Autowired
    private StarWarsClient starWarsClient;

	public List<ResultDto> getPersonas(int page, int limit) {
    	ResponseDto peopleResponseDto =  starWarsClient.getPersonas(page, limit);
    	return peopleResponseDto.getResults();
    }
	
    public PersonDto getPersonaByName(String name) {
    	PeopleNameResponseDto peopleNameResponseDto =  starWarsClient.getPersonaByName(name);
    	List<ResultNameDto> resultName = peopleNameResponseDto != null ? peopleNameResponseDto.getResult() : null;
    	
    	if (resultName != null && !resultName.isEmpty()) {
    	    return resultName.get(0).getProperties();
    	}        	
    	return null;
    }

    public PersonDto getPersonaById(String id) {
    	PersonResponseDto personResponseDto = starWarsClient.getPersonaById(id);
    	return personResponseDto.getResult().getProperties();
    }
}
