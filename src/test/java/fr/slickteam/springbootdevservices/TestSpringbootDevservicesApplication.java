package fr.slickteam.springbootdevservices;

import fr.slickteam.springbootdevservices.config.ContainersConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

public class TestSpringbootDevservicesApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootDevservicesApplication::main)
				.with(ContainersConfiguration.class)
				.run(args);
	}

}
