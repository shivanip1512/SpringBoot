package com.shivani.springboot.jpa;

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
		
		User u = new User();
		u.setName("Shivani");
		u.setStatus("I am a Java Programmer");
		
		User user = userRepo.save(u);
		System.out.println(user);
	}

}
