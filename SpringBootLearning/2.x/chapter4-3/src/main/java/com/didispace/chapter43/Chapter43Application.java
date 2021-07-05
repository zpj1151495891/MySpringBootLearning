package com.didispace.chapter43;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class Chapter43Application {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		SpringApplication.run(Chapter43Application.class, args);
	}

}
