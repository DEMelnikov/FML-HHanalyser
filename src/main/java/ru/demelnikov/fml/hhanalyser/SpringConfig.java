package ru.demelnikov.fml.hhanalyser;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.demelnikov.fml.hhanalyser")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
