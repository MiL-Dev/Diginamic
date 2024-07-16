package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class TestSchedulerApplication {

	private int count = 1;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSchedulerApplication.class, args);
	}
	@Scheduled(cron = "* * * * * *") //Permet de mettre du temps a l'execution
	private void tick() {
		
		if(count++%2==0) {
			System.out.println("Tack");
		}else {
			System.out.println("Tick");
		}
		System.out.println(System.currentTimeMillis()); // Nombre de Ms entre chaque execution de la fonction tick()
	}
}
