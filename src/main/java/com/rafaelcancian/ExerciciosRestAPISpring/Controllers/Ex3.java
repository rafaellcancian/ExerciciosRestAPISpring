//3 - Faça uma API que recebe um número e retorne se este é par ou impar.

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ex3")
public class Ex3 {
	
	int num = 0;
	
	@GetMapping
	public String getValor() {
		if (num % 2 == 0) {
			return "O número " + num + " é par.";
		} else {
			return "O número " + num + " é ímpar.";
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String recebeValor(@RequestBody int num) {
		this.num = num;
		return "O valor " + num + " foi recebido com sucesso!";
	}
}
