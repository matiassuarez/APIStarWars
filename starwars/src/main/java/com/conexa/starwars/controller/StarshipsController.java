package com.conexa.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.dto.StarshipDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.service.StarshipService;

@RestController
@RequestMapping("/api/starwars/starships")
public class StarshipsController {

	@Autowired
    private StarshipService starshipService;
	
    @GetMapping("")
    List<ResultDto> getStarships(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	return starshipService.getStarships(page, limit);
    }

    @GetMapping("{id}")
    StarshipDto getStarshipById(@PathVariable("id") String id) {
    	return starshipService.getStarshipById(id);
    }
}
