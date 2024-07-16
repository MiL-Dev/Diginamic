package fr.diginamic.hello.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
	
	@ExceptionHandler({AnomalieException.class})
	protected ResponseEntity<String> traiterErreurs(AnomalieException e) {
		System.out.println("Je passe bien par mon Gestionnaire d'excepton");
		return ResponseEntity.badRequest().body(e.getMessage());
		}
}
