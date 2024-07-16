package com.conexa.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.dto.VehicleDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.service.VehiclesService;

@RestController
@RequestMapping("/api/starwars/vehicles")
public class VehiclesController {

	@Autowired
    private VehiclesService vehiclesService;
	
    @GetMapping("")
    List<ResultDto> getVehicles(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
    	return vehiclesService.getVehicles(page, limit);
    }
    
    @GetMapping("{id}")
    VehicleDto getVehiclesById(@PathVariable("id") String id) {
    	return vehiclesService.getVehiclesById(id);
    }
}
