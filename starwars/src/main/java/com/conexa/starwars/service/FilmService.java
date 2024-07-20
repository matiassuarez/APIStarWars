package com.conexa.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.FilmResponseDto;
import com.conexa.starwars.dto.FilmResponseDto.FilmResultDto;
import com.conexa.starwars.dto.FilmsResponseDto.FilmsResultDto;
import com.conexa.starwars.dto.FilmsResponseDto;

/**
 * Servicio para gestionar las operaciones relacionadas a los recursos peliculas
 * en la API de Star Wars.
 * @author MSuarez
 */
@Service
public class FilmService {
	@Autowired
    private StarWarsClient starWarsClient;
	
	/**
     * Obtiene una lista de peliculas.
     *
     * @param page numero de pagina de los resultados a obtener.
     * @param limit numero maximo de resultados por pagina.
     * @return {@link FilmsResultDto} representa las peliculas.
     */
	public List<FilmsResultDto> getFilms(int page, int limit) {
		FilmsResponseDto filmsResponseDto = starWarsClient.getFilms(page, limit);
		return filmsResponseDto.getResult();
    }

	/**
     * Obtiene una pelicula por ID.
     *
     * @param id ID de la pelicula a buscar.
     * @return {@link FilmResultDto} representa la pelicula.
     */
    public FilmResultDto getFilmById(String id) {
    	FilmResponseDto filmResponseDto = starWarsClient.getFilmsById(id);
        return filmResponseDto.getResult();
    }
}
