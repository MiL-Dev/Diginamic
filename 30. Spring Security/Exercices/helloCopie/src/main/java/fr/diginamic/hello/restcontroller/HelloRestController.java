package fr.diginamic.hello.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.services.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
	@Autowired
	private HelloService service;
	
	@GetMapping
	public String direHello() {
		return service.salutation();
	}
}
