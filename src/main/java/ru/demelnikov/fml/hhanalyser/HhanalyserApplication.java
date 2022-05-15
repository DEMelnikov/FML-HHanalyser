package ru.demelnikov.fml.hhanalyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.demelnikov.fml.hhanalyser.Ranges.RangesDB;

import java.io.FileNotFoundException;

@SpringBootApplication
public class HhanalyserApplication {

	public static void main(String[] args) throws FileNotFoundException {

		//SpringApplication.run(HhanalyserApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		GGReportParser ggReportParser = context.getBean("ggReportParser", GGReportParser.class);

		HandsDB handsDB = context.getBean("handsDB", HandsDB.class);
		RangesDB rangesDB = context.getBean("rangesDB", RangesDB.class);

		ggReportParser.UpdateDB(handsDB);

		System.out.println("Всего рук: ");

		handsDB.index();

		context.close();
	}


}
