package com.conexa.starwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción {@link RecursoNoEncontradoException}.
     *
     * @param ex la excepción lanzada.
     * @return una respuesta con el código de estado HTTP 404 y un mensaje de error.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleRecursoNoEncontradoException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Puedes agregar más métodos para manejar otras excepciones aquí
}
