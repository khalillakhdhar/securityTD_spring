package com.sec.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sec.security.dao.TaskRepository;
import com.sec.security.entities.AppRole;
import com.sec.security.entities.AppUser;
import com.sec.security.entities.Task;
import com.sec.security.service.AccountService;


@SpringBootApplication
public class SecurityTdApplication implements CommandLineRunner {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(SecurityTdApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser(new AppUser("admin", "1234",1,null));
		accountService.saveUser(new AppUser("user", "1234",1,null));
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user", "USER");
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(t));});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName()+" saved");
		});
			}
			
}
			

