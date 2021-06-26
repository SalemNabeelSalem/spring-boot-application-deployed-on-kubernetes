package com.salemnabeel.k8sdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class K8sDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(K8sDemoApplication.class, args);
	}

	@GetMapping("/lucky-day")
	public String myLuckyDay() {
		Random random = new Random();
		return random.nextBoolean() ? "It's your lucky day :D" : "Oh no ! Try again.";
	}
}