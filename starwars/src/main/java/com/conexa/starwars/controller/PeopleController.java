package com.conexa.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.service.PeopleService;

@RestController
@RequestMapping("/api/starwars/people")
public class PeopleController {
	@Autowired
    private PeopleService peopleService;
	
    @GetMapping("")
    public List<ResultDto> getPeople(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        return peopleService.getPersonas(page, limit);
    }
    
    @GetMapping("/search")
    public PersonDto getPeopleByname(@RequestParam String name) {
        return peopleService.getPersonaByName(name);
    }

    @GetMapping("{id}")
    public PersonDto getPersonById(@PathVariable String id) {
        return peopleService.getPersonaById(id);
    }

}
