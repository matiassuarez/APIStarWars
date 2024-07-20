package com.conexa.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.exception.ResourceNotFoundException;
import com.conexa.starwars.service.StarshipService;

@RestController
@RequestMapping("/api/starwars/starships")
public class StarshipsController {

	@Autowired
    private StarshipService starshipService;
	
    @GetMapping("")
    ResponseEntity<Object> getStarships(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	try {
    		return new ResponseEntity<>(starshipService.getStarships(page, limit), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    ResponseEntity<Object> getStarshipById(@PathVariable("id") String id) {
    	try {
    		return new ResponseEntity<>(starshipService.getStarshipById(id), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Nave Espacial no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
