package com.conexa.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexa.starwars.dto.FilmDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;
import com.conexa.starwars.service.FilmService;

@RestController
@RequestMapping("/api/starwars/films")
public class FilmsController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("")
    public List<ResultDto> getFilms(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        return filmService.getFilms(page, limit);
    }

    @GetMapping("{id}")
    public FilmDto getFilmById(@PathVariable String id) {
        return filmService.getFilmById(id);
    }

}
