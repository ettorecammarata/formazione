package com.besidetech.training;

import com.besidetech.training.modelDto.ChargeDto;
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

//			User user = new User()  ;
//			Json
//			System.out.println( chargeRepository.findChargeByProjectId(11));
//
//			Map<Integer, Map<Integer, ChargeDto>> charge = new HashMap<>() ;
//
//			Map<Integer , ChargeDto> interno = new HashMap<>();
//			interno.put(1 , chargeService.findById(14733));
//			interno.put(2 , chargeService.findById(14748));
//			charge.put(1 , interno) ;
//
//			chargeService.saveAll(charge) ;



			System.out.println("----END---");
		};
	}




}