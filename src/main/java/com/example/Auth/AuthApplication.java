package com.example.Auth;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AuthApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	public void run(String... args){
		System.out.println("HERE?");
	}

}
