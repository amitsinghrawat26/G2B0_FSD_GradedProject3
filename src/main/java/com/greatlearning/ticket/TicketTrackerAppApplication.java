package com.greatlearning.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TicketTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerAppApplication.class, args);
	}

}
	