package ru.demelnikov.fml.hhanalyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HhanalyserApplication {

	public static void main(String[] args) {

		//SpringApplication.run(HhanalyserApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Всего рук: ");

		context.close();
	}


}
