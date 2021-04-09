//2 - Faça uma API que recebe a temperatura em fahrenheit e retorne em celsius.

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ex2")
public class Ex2 {
	
	double valorFahrenheit = 0;
	
	@GetMapping
	public String getValor() {
		double valorCelsius = ((5 * (valorFahrenheit - 32.0)) / 9.0);
		
		return "A temperatura em Celsius é: " + valorCelsius;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String recebeValor(@RequestBody double valorFahrenheit) {
		this.valorFahrenheit = valorFahrenheit;
		return "O valor " + valorFahrenheit + " foi recebido com sucesso!";
	}
	
}
