package com.conexa.starwars.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.conexa.starwars.dto.FilmResponseDto;
import com.conexa.starwars.dto.PeopleNameResponseDto;
import com.conexa.starwars.dto.PersonResponseDto;
import com.conexa.starwars.dto.ResponseDto;
import com.conexa.starwars.dto.StarshipResponseDto;
import com.conexa.starwars.dto.VehicleResponseDto;

/**
 * Cliente del servicio de StarWars
 *
 * @author esteban
 */
@FeignClient(name = "swapi", url = "https://www.swapi.tech/api")
public interface StarWarsClient {

	@GetMapping("/people")
	ResponseDto getPersonas(@RequestParam("page") int page, @RequestParam("limit") int limit);
	
	@GetMapping("/people")
	PeopleNameResponseDto getPersonaByName(@RequestParam("name") String name);

	@GetMapping("/people/{id}")
	PersonResponseDto getPersonaById(@PathVariable("id") String id);

	@GetMapping("/starships")
	ResponseDto getStarships(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping("/starships/{id}")
    StarshipResponseDto getStarshipById(@PathVariable("id") String id);
    
    @GetMapping("/vehicles")
	ResponseDto getVehicles(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping("/vehicles/{id}")
    VehicleResponseDto getVehiclesById(@PathVariable("id") String id);
    
    @GetMapping("/films")
	ResponseDto getFilms(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping("/films/{id}")
    FilmResponseDto getFilmsById(@PathVariable("id") String id);

}
