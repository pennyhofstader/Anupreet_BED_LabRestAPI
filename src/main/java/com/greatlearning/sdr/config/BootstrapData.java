package com.greatlearning.sdr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.sdr.entity.Role;
import com.greatlearning.sdr.entity.Student;
import com.greatlearning.sdr.entity.User;
import com.greatlearning.sdr.repo.StudentRepo;
import com.greatlearning.sdr.repo.UserRepo;

//adding user and students for testing
@Configuration
public class BootstrapData {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// data for student table
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void studentData(ApplicationReadyEvent readyEvent) {

		Student s1 = new Student("Suresh", "Reddy", "B.Tech", "India");
		Student s2 = new Student("Marali", "Mohan", "B.Arch", "Canada");
		Student s3 = new Student("Daniel", "Denson", "B.Tech", "New Zealand");
		Student s4 = new Student("Tanya", "Gupta", "B.Com", "USA");

		this.studentRepo.save(s1);
		this.studentRepo.save(s2);
		this.studentRepo.save(s3);
		this.studentRepo.save(s4);
	}

	// data for users and roles
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void usersData(ApplicationReadyEvent readyEvent) {

		User khushi = new User("khushi", passwordEncoder.encode("khushi"));
		User anu = new User("anu", passwordEncoder.encode("anu"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		khushi.addRole(userRole);

		anu.addRole(adminRole);

		this.userRepo.save(khushi);
		this.userRepo.save(anu);

	}

}
