package com.conexa.starwars.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
class HomeContoller {

	@GetMapping("")
	public String index() {
	    return """
	       <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <title>API de Star Wars</title>
                <link href="styles.css" rel="stylesheet" type="text/css">
                <style>
                    body {
                        background-image: url('/images/starwars-background.jpg');
                        background-size: cover;
                        background-repeat: no-repeat;
                        background-attachment: fixed;
                        color: white;
                    }
                    h2, p, button {
                        text-shadow: 1px 1px 2px black;
                    }
                </style>
            </head>
            <body>
                <h1>API de Star Wars</h1>
                <h3>Prueba Técnica</h3>
                <script>
                    function getURL() {
                        window.location.assign(window.location.href + "swagger-ui-custom.html");
                    }
                    function getPostman() {
                        window.location.assign(window.location.href + "postman");
                    }
                </script>
                <div>
                    <button type="button" onclick="getURL();">Documentacion de Servicios mediante Swagger</button>
                </div>
                <br/>
                <div>
                    <button type="button" onclick="getPostman();">Descargar proyecto de Postman</button>
                </div>
            </body>
        </html>
        """;
	}

    
	@GetMapping("/postman")
	public void downloadPostman(HttpServletResponse response) throws IOException {
        // Usa la ruta relativa desde src/main/resources
        ClassPathResource resource = new ClassPathResource("postman/example/StarWars.postman_collection.json");
        File file = resource.getFile();
        
        response.setContentType("application/json"); // Tipo de contenido JSON
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());
        response.setContentLength((int) file.length());

        try (BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream())) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Registra el error para depuración
        }
    }
}