package com.besidetech.training;

import com.besidetech.training.repository.ChargeRepository;
import com.besidetech.training.repository.ProjectRepository;
import com.besidetech.training.repository.UserRepository;
import com.besidetech.training.service.ChargeService;
import com.besidetech.training.service.ProjectService;
import com.besidetech.training.service.UserProjectService;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingApplication {

	@Autowired
	UserService userService ;
	@Autowired
	ProjectService projectService ;
	@Autowired
	UserProjectService userProjectService ;
	@Autowired
	ChargeService chargeService;
	@Autowired
	ChargeRepository chargeRepository ;
	@Autowired
	UserRepository userRepository ;
	@Autowired
	ProjectRepository projectRepository;



	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public CommandLineRunner dateGenerator(ApplicationContext ctx) {
		return (args) -> {

			System.out.println("----END---");
		};
	}




}