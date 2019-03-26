package com.ozdogan.eventManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(
basePackageClasses= {EventManagementApiApplication.class,
		Jsr310Converters.class} )
@EnableJpaRepositories(basePackages=
{"com.ozdogan.eventManagementAPI.repositories"})
public class EventManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApiApplication.class, args);
	}
}
