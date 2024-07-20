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
import com.conexa.starwars.service.PeopleService;

@RestController
@RequestMapping("/api/starwars/people")
public class PeopleController {
	@Autowired
    private PeopleService peopleService;
	
    @GetMapping("")
    public ResponseEntity<Object> getPeople(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonas(page, limit), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<Object> getPeopleByname(@RequestParam String name) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonaByName(name), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable String id) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonaById(id), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

}
