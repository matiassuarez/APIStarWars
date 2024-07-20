package com.conexa.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.dto.VehicleResponseDto.VehicleDto;
import com.conexa.starwars.exception.ResourceNotFoundException;
import com.conexa.starwars.service.VehiclesService;

@RestController
@RequestMapping("/api/starwars/vehicles")
public class VehiclesController {

	@Autowired
    private VehiclesService vehiclesService;
	
    @GetMapping("")
    ResponseEntity<Object> getVehicles(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	try {
    		return new ResponseEntity<>(vehiclesService.getVehicles(page, limit), HttpStatus.OK);
    	} catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Object> getVehiclesById(@PathVariable("id") String id) {
    	 try {
             VehicleDto vehicleDto = vehiclesService.getVehiclesById(id);
             return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
         } catch (ResourceNotFoundException e) {
             return new ResponseEntity<>("Vehículo no encontrado", HttpStatus.NOT_FOUND);
         }
    }
}
