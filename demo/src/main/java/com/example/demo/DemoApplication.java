package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repo.Userrepo;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	Userrepo urepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u = urepo.findByLogAndPass2("moi", "pass");
		if(u!=null)
		System.out.println(u.toString());
			}

}
