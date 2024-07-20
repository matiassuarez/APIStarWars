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
import com.conexa.starwars.service.FilmService;

@RestController
@RequestMapping("/api/starwars/films")
public class FilmsController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("")
    public ResponseEntity<Object> getFilms(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		try {
    		return new ResponseEntity<>(filmService.getFilms(page, limit), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getFilmById(@PathVariable String id) {
    	try {
    		return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.NOT_FOUND);
        }
    }

}
