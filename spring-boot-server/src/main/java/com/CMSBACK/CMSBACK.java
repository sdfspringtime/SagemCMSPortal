package com.CMSBACK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("..")
@SpringBootApplication
public class CMSBACK {

	public static void main(String[] args) {
		SpringApplication.run(CMSBACK.class, args);
	}

}
