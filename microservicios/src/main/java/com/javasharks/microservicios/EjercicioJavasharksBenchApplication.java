package com.javasharks.microservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EjercicioJavasharksBenchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioJavasharksBenchApplication.class, args);
	}

}
