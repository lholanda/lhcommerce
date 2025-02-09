package nl.lhdev.lhcommerce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LhcommerceApplication {

	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false"); // Enable hot reload "true" or "false"
		SpringApplication.run(LhcommerceApplication.class, args);  

		System.out.println("starting the application....");

		Runnable executRunnable = () -> ideasFactory();
		executRunnable.run();
	}

	public static void ideasFactory(){

		Set<Integer> listaComSet = new HashSet<>();
		listaComSet.add(10);
		listaComSet.add(11);
		listaComSet.add(12);
		listaComSet.add(10);
		listaComSet.add(10);
		listaComSet.add(11);
		listaComSet.add(11);
		listaComSet.add(15);

		System.out.println("Set() does not accept repeated elements");
		listaComSet.stream()
		           .forEach(System.out::println);

	}

}
