package com.besidetech.Training;

import com.besidetech.Training.model.User;
import com.besidetech.Training.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TrainingApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(TrainingApplication.class, args);

	}

	@Bean
	public CommandLineRunner dateGenerator(ApplicationContext ctx) {
		return (args) -> {
			User user = new User();
			user.setCreated(new Date(2022 , 10 , 11));
			user.setCreted_by(1);
			user.setLast_update(new Date(2022 , 10 , 12));
			user.setUsername("username1");
			user.setPassword("password1");
			user.setEmail("email1");
			user.setGender('M');
			user.setActive(true);
			user.setName("nome");
			user.setSurname("surname");
			System.out.println("sto creando un utente prova " + user);
			System.out.println("procedo al salvataggio");
			userRepository.save(user);
		};
	}
}
