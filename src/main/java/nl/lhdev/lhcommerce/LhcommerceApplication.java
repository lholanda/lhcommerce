package nl.lhdev.lhcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LhcommerceApplication {

	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false"); // Enable hot reload "true" or "false"
		SpringApplication.run(LhcommerceApplication.class, args);  

		System.out.println("starting the application....");
	}

}
