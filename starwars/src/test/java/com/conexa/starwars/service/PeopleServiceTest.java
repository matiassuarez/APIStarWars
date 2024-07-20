package com.conexa.starwars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.conexa.starwars.client.StarWarsClient;
import com.conexa.starwars.dto.PersonResponseDto.PersonDto;
import com.conexa.starwars.dto.ResponseDto.ResultDto;

import java.util.Collections;
import java.util.List;

public class PeopleServiceTest {

    @Mock
    private StarWarsClient starWarsClient;

    @InjectMocks
    private PeopleService peopleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPeople() {
        // Arrange
        List<ResultDto> mockResults = Collections.singletonList(new ResultDto());
        when(starWarsClient.getPersonas(1, 3).getResults()).thenReturn(mockResults);

        // Act
        List<ResultDto> serviceResponse = peopleService.getPersonas(1, 3);

        // Assert
        assertEquals(mockResults, serviceResponse);
    }

    @Test
    void testGetPersonById() {
        // Arrange
        PersonDto mockPerson = new PersonDto();
        when(starWarsClient.getPersonaById("2").getResult().getProperties()).thenReturn(mockPerson);

        // Act
        PersonDto serviceResponse = peopleService.getPersonaById("2");

        // Assert
        assertEquals(mockPerson, serviceResponse);
    }
}
