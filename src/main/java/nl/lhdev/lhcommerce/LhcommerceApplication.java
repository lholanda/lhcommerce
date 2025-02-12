package nl.lhdev.lhcommerce;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		//executRunnable.run();
	}




	


	/*
	 * funcao para implementar implementacoes rápidas de codigos para testar ao mesmo tempo que desenvolve o sistema
	 */
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
		/*
		 System.out.println("Set() does not accept repeated elements");
		listaComSet.stream()
		.forEach(System.out::println);
		*/

		// https://www.youtube.com/watch?v=WnJUI-jMQGE
		
		LocalDate dataLocal01 = LocalDate.now();
		LocalDateTime dataLocal02 = LocalDateTime.now();

		LocalDate dataLocal03 = LocalDate.parse("1976-02-02");
		LocalDateTime dataLocal04 = LocalDateTime.parse("1976-02-02T14:52:04");

		Instant dataGlobal01 = Instant.now();
		

		System.out.println(" ");
		System.out.println("Local");
		System.out.println(dataLocal01);
		System.out.println(dataLocal02);

		System.out.println(dataLocal03);
		System.out.println(dataLocal04);
		
		System.out.println(" ");
		System.out.println("Global - Londres ");
		System.out.println(dataGlobal01);

	}

}


/*

https://www.youtube.com/watch?v=WnJUI-jMQGE


 * mais importantes
 * 
 * agora -> data-hora 
 * texto ISO 8601 -> data-hora 
 * 
 * Obter dados de uma data-hora local
 * -> dia, mes, ano, horario
 * 
 * Converter data-hora global para local
 * Data-hora global, timezone (sistema local) -> Data-hora local
 * 
 * Data em JAVA 
 * data-hora local
 * LocalDate
 * LocalDateTime
 * 
 * data-hora global
 * Instant
 * 
 * Duracao 
 * duration
 * 
 * 
 */


// testes com datas
		// Data-hora local
		// Data-hora global
		/*
		 * 2022-07-23T14:30:00Z - horario de londres
		 * 15:30 - portugual
		 * 11:30 - brazil
		 
		 DATA-HORA local
		 * usado quando nao precisar de fuso horario
		 * 15/06/2001 - DATA NASCIMENTO
		 * 13/08/2022 as 15:30 - DATA DE VENDA (caso o fuso nao interessar)
		 * 
		  DATA-HORA Global
		  comentario foi postado - ha 17 minutos atras
		  
		  GMT - UTC 0 ou Z TIME ou Zulu time

		  Sao Paulo GMT-3 (3 horas antes de londres)
		  Portugual GMT+1

		  Padrao ISO 8601

		 * 
		 */
		// Duracao - tempo decorrido entre duas datas
