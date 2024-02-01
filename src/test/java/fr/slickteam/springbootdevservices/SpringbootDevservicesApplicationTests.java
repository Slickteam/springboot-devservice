package fr.slickteam.springbootdevservices;

import fr.slickteam.springbootdevservices.tests.DatabaseIT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDevservicesApplicationTests extends DatabaseIT {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}

}
