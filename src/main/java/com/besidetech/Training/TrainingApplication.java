package com.besidetech.Training;

import com.besidetech.Training.model.Charge;
import com.besidetech.Training.model.Project;
import com.besidetech.Training.model.User;
import com.besidetech.Training.repo.ChargeRepository;
import com.besidetech.Training.service.ChargeService;
import com.besidetech.Training.service.ProjectService;
import com.besidetech.Training.service.UserProjectService;
import com.besidetech.Training.service.UserService;
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

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public CommandLineRunner dateGenerator(ApplicationContext ctx) {
		return (args) -> {
			Optional<User> user = Optional.of(new User());
			Optional<Project> project = Optional.of(new Project ()) ;

	/*		user.setCreated(new Date(2022 , 10 , 11));
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
			userRepository.save(user);*/
			//user = userService.findById(46) ;
			//project = projectService.findById(5) ;

			//project = projectRepository.findById(5) ;

			/*if (project.isPresent() && user.isPresent()) {
				User updateUser = user.get() ;
				System.out.println("update user ---------------> " + updateUser);
				//updateUser.getEngagedProjects().add(project.get());
				//userService.save(updateUser) ;
			}*/

			//User u = (user.isPresent())  ? user.get() : null  ;
			//System.out.println(u);
			//Project p = (project.isPresent()) ? project.get() : null ;
			//System.out.println(p);
		/*	UserProject up = new UserProject() ;
			up.setCreted(new Date());
			up.setProject(p);
			up.setLasyUpdate(new Date());
			up.setUser(u);*/
			//userProjectService.save(up);

			/*
			Set<UserProject> tmpSet = u.getProjects() ;
			for (UserProject t : tmpSet) {
				System.out.println(t);
			}*/
			//System.out.println(userProjectService.findById(391L).get() );

			//userProjectService.findByUserId(46).getId() ;
			//System.out.println(userProjectService.findByUserId(46).getUser());
			//System.out.println(userService.findByNameAndSurname("nome" , "surname"));


			User io = userService.findById(46).get() ;
			Project pro = projectService.findById(1).get() ;


			List<Charge> ls = new ArrayList<>() ;
			Charge c = new Charge () ;
			c.setCreated(new Date () );
			c.setCreated_by(46);
			c.setHours(5.0f);
			c.setDay(new Date());
			c.setUser(io);
			c.setProject(pro);
			
			//chargeService.save(ls);

			Date start = new Date();
			start.setDate(7);

			Date end = new Date() ;

			List<Charge> lista = chargeRepository.findByUserIdAndDayBetween(46 ,start , end  ) ;

			System.out.println("dimensione : " +lista.size());
			System.out.println("----END---");

		};
	}
}