package com.ftunicamp.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TccApplication {
//Sistema GAS v1.01.5 (stack heroku-22)
    public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
	}

}
