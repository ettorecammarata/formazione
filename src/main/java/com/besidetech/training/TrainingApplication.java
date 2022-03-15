package com.besidetech.training;

import com.besidetech.training.model.User;
import com.besidetech.training.model.converter.ConverterUser;
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

import java.util.*;

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

	Date getDateIntervalToToday (Integer x ){
		Date result = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(result);
		calendario.add(Calendar.DATE, -x);
		Date dateBefore7Days = calendario.getTime();
		return result ;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public CommandLineRunner dateGenerator(ApplicationContext ctx) {
		return (args) -> {
//			Optional<User> user = Optional.of(new User());
//			Optional<Project> project = Optional.of(new Project ()) ;
//
//			List<Project> lista=projectRepository.findByProjectsUserId(54);
//			System.out.println(lista);

			User oProva = userService.findById(1) .get();
			ConverterUser converter = new ConverterUser() ;

//			UserDto provaDto = converter.convert (new UserDto () , oProva) ;
//			System.out.println(provaDto);

			List<Optional<User>> listaUser = Collections.singletonList(userService.findById(46));
			for (Optional<User> user : listaUser) {
				System.out.println(user);
			}


			System.out.println("----END---");
		};
	}




}