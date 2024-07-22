package com.conexa.starwars.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    
	 /**
     * Endpoint para manejar errores y redirigir al usuario a la pagina principal.
     *
     * @param request HttpServletRequest contiene la solicitud del cliente
     * @return ModelAndView redirige a la pagina principal
     */
	@RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        return new ModelAndView("redirect:/");
    }
}
