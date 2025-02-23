package nl.lhdev.lhcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LhcommerceApplication {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		final String devToolsSet = ( ! true ? "true" : "false");  

		System.setProperty("spring.devtools.restart.enabled", devToolsSet); // Enable hot reload "true" or "false"

		SpringApplication.run(LhcommerceApplication.class, args);

		//Runnable executeRunnable = () -> ExecutorIdeas.ideasLists();
		// executeRunnable.run();
	}

	
}

