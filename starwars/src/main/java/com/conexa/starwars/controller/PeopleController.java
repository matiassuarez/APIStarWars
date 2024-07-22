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
	
	/**
     * Endpoint para obtener una lista de personas con paginación.
     *
     * @param page  Numero de la pagina (por defecto 1)
     * @param limit Cantidad resultados por pagina (por defecto 10)
     * @return ResponseEntity lista de personas y el estado HTTP
     */
    @GetMapping("")
    public ResponseEntity<Object> getPeople(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonas(page, limit), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Endpoint para buscar personas por ID.
     *
     * @param name Nombre de la persona a buscar
     * @return ResponseEntity lista de personas encontradas y el estado HTTP
     */
    @GetMapping("/search")
    public ResponseEntity<Object> getPeopleByname(@RequestParam String name) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonaByName(name), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint para obtener una persona por ID.
     *
     * @param id ID de la persona
     * @return ResponseEntity con el DTO de la persona y el estado HTTP
     */
    @GetMapping("{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable String id) {
    	try {
    		return new ResponseEntity<>(peopleService.getPersonaById(id), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

}
