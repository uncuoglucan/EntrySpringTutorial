package com.canuncuoglu.runners;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.canuncuoglu.runners.run.Location;
import com.canuncuoglu.runners.run.Run;
import com.canuncuoglu.runners.run.RunRepository;


@SpringBootApplication
public class RunnersApplication {

	//private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR);
	// 		runRepository.create(run);
	// 		// log.info("Run: " + run);
	// 	};
	// }
}
