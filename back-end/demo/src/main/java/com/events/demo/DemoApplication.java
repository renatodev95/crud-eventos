package com.events.demo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.events.demo.model.Event;
import com.events.demo.repository.EventRepository;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(EventRepository eventRepository) {
		return args -> {
			eventRepository.deleteAll();
			Event e = new Event();
			e.setTitle("EVENTO 1");
			e.setDescription("DESCRIÇÃO EVENTO 1");
			e.setEventDate(LocalDate.now()); 
			eventRepository.save(e); 
		};
	}
}
