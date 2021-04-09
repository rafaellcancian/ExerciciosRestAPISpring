//1 - Faça uma API que retorne o data e a hora atual

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ex1")
public class Ex1 {
	@GetMapping
	public String getDataHora() {
		SimpleDateFormat formatter= new SimpleDateFormat("'Data: ' dd/MM/yyyy 'Hora: ' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		
		return formatter.format(date);
	}
	
}
