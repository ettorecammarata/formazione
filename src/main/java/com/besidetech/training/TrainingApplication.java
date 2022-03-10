package com.besidetech.training;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.repo.ChargeRepository;
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


//			User io = userService.findById(46).get() ;
//			Project pro = projectService.findById(1).get() ;
//
//
//			List<Charge> ls = new ArrayList<>() ;
//			Charge c = new Charge () ;
//			c.setCreated(new Date () );
//			c.setCreated_by(46);
//			c.setHours(5.0f);
//			c.setDay(new Date());
//			c.setUser(io);
//			c.setProject(pro);

			//chargeService.save(ls);

//			Date start = new Date();
//			start.setDate(7);
//
//			Date end = new Date() ;
//
//			List<Charge> lista = chargeRepository.findByUserIdAndDayBetween(46 ,start , end  ) ;
//
//			System.out.println("dimensione : " +lista.size());


//			Date oggi = new Date() ;
//			List<User> queryResponse = userService.findByCreatedOrderByNameDesc(oggi);
//			System.out.println(oggi);

//			System.out.println(queryResponse.size());

//			for (User u : queryResponse	 ) {
//				System.out.println();
//			}
//			Project p = new Project() ;
//			p.setId(10);
//			List<UserProject> lista = userProjectService.findUserByProject(p) ;
//			System.out.println(lista.size());

//			Charge c = new Charge() ;
//			c.setCreated(new Date());
//			c.setCreated_by(1);
//			List<Charge> lc = new ArrayList<>() ;
//			lc.add(c) ;
//			chargeService.save(lc);


////			#####################################################
			Date start = new Date();
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(start);
			calendario.add(Calendar.DATE, -9);
			Date dateBefore7Days = calendario.getTime();
////			######################################################
//			List<UserProject> lista = userProjectService.findByCreatedBetween(dateBefore7Days , new Date () ) ;
//			for (UserProject x : lista  ) {
//				System.out.println( x );
//			}
//			System.out.println("START : " + dateBefore7Days + " END " + new Date());


			Charge c = new Charge() ;
			c.setCreated_by(1);
			Date dataCreazione = new Date() ;
			Calendar cal = Calendar.getInstance() ;
			cal.set(2022 , 2 ,7);
			dataCreazione=cal.getTime();
			c.setCreated(dataCreazione);
			Project projectTmp = new Project() ;
			projectTmp.setId(12);
			c.setProject(projectTmp);
			User userTmp = new User();
			userTmp.setId(46) ;
			c.setUser(userTmp);
			List<Charge> carichiTmp = new ArrayList<>() ;
			carichiTmp.add(c) ;
//			chargeService.save(carichiTmp);



			Date d = new Date() ;
			Set<Charge> risult = new TreeSet<>() ;


			Collection<Charge> risultato = chargeRepository.findByUserIdAndDayBetweenOrderByProjectId( 46 , dateBefore7Days , d ) ;



//			risult.addAll(risultato )  ;
			System.out.println("------------------------" + risult.size());

			for (Charge ch : risultato  ) {
				System.out.println(ch );
			}

			System.out.println("----END---");

		};
	}
}