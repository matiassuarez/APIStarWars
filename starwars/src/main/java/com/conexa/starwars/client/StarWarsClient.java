package com.conexa.starwars.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.conexa.starwars.client.dto.PeopleNameResponseDto;
import com.conexa.starwars.client.dto.PeopleResponseDto;
import com.conexa.starwars.client.dto.PersonResponseDto;

/**
 * Cliente del servicio de StarWars
 *
 * @author esteban
 */
@FeignClient(name = "swapi", url = "https://www.swapi.tech/api")
public interface StarWarsClient {

	@GetMapping("/people")
	PeopleResponseDto getPersonas(@RequestParam("page") int page, @RequestParam("limit") int limit);
	
	@GetMapping("/people")
	PeopleNameResponseDto getPersonaByName(@RequestParam("name") String name);

	@GetMapping("/people/{id}")
	PersonResponseDto getPersonaById(@PathVariable("id") String id);

	// Métodos similares para films, starships y vehicles
}
