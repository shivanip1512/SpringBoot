package com.shivani.springboot.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.shivani.springboot.jpa.dao.UserRepo;
import com.shivani.springboot.jpa.entity.User;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserRepo userRepo = applicationContext.getBean(UserRepo.class);

		/*
		 * User u = new User(); u.setName("Shivani");
		 * u.setStatus("I am a Java Programmer");
		 * 
		 * saving single object User user = userRepo.save(u); System.out.println(user);
		 */

		/*
		 * User u1=new User(); u1.setName("name1"); u1.setStatus("python programmer");
		 * 
		 * 
		 * User u2=new User(); u2.setName("name2"); u2.setStatus("c++ programmer");
		 * 
		 * List<User> list = new ArrayList<>(); list.add(u1); list.add(u2);
		 * 
		 * //save multiple objects Iterable<User> saveAll = userRepo.saveAll(list);
		 * 
		 * saveAll.forEach(u->System.out.println(u));
		 */

		/*
		 * // update Optional<User> user = userRepo.findById(2);
		 * 
		 * User user2 = user.get(); user2.setName("Sweety");
		 * user2.setStatus("C Programmer");
		 * 
		 * User updatedUser = userRepo.save(user2); System.out.println(updatedUser);
		 */

		/*
		 * //delete userRepo.deleteById(3);
		 */

		
		/*
		 * //custom finder
		 * List<User> list = userRepo.findByName("Shivani");
		 * 
		 * for (User user : list) { System.out.println(user); }
		 */
		
		/*
		 * List<User> allUsers = userRepo.getAllUsers();
		 * 
		 * for (User user : allUsers) { System.out.println(user); }
		 */
		
		/*
		 * List<User> userByStatus = userRepo.getUserByName("Shivani");
		 * 
		 * for (User user : userByStatus) { System.out.println(user); }
		 */
	
		//native query
		List<User> users = userRepo.getUsers();
		
		users.forEach(u->{
			System.out.println(u);
		});
	
	}
}