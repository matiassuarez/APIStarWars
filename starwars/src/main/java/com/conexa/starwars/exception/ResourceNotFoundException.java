package com.conexa.starwars.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * Excepcion que se lanza cuando no se encuentra un recurso.
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}