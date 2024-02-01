package fr.slickteam.springbootdevservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringbootDevservicesApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootDevservicesApplication::main).with(TestSpringbootDevservicesApplication.class).run(args);
	}

}
