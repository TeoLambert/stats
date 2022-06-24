package fr.gamedev.stats.controller;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHateoasLauncher {

	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringHateoasLauncher.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8081"));
              app.run(args);
	}

}
