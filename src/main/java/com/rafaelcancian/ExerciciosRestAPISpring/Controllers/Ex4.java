/*
 * 4 - Faça uma API que simule a votação em uma urna eletronica para a votação para prefeito.
 * A API recebe o numero do candidato e contabiliza os votos. Tambem deve listar o resultado parcial e o resultado por candidato.
 */

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelcancian.ExerciciosRestAPISpring.Models.Candidato;

@RestController
@RequestMapping("/Ex4")
public class Ex4 {

	List<Candidato> candidatos = new ArrayList<Candidato>();
	int numCandidatos = 2;
	
	boolean candidatosCriados = false;
	
	@GetMapping
	public String getCandidatos() {
		if (candidatosCriados == false) {
			criarCandidatos();
			candidatosCriados = true;
		}
		
		String mensagem = "";
		
		for (int i = 0; i < numCandidatos; i++) {
			mensagem += candidatos.get(i).getNome() + " (" + candidatos.get(i).getNumPartido() + ") - Votos: " + candidatos.get(i).getVotos() + "\n";
		}
		
		return "Votação para prefeito:\n" + mensagem;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String recebeValor(@RequestBody String numPartido) {
		if (numPartido.equals("15")) {
			int tempVotos = candidatos.get(0).getVotos();
			tempVotos++;
			candidatos.get(0).setVotos(tempVotos);
			
			return "O voto para o candidato " + candidatos.get(0).getNome() + " foi computado com sucesso!";
		} else if (numPartido.equals("30")) {
			int tempVotos = candidatos.get(1).getVotos();
			tempVotos++;
			candidatos.get(1).setVotos(tempVotos);
			
			return "O voto para o candidato " + candidatos.get(1).getNome() + " foi computado com sucesso!";
		} else {
			return "O número do partido informado não existe.";
		}
	}
	
	@GetMapping("/{numPartido}")
	public String getCandidato(@PathVariable String numPartido) {
		if (numPartido.equals("15")) {
			return candidatos.get(0).getNome() + " (" + candidatos.get(0).getNumPartido() + ") - Votos: " + candidatos.get(0).getVotos();
		} else if (numPartido.equals("30")) {
			return candidatos.get(1).getNome() + " (" + candidatos.get(1).getNumPartido() + ") - Votos: " + candidatos.get(1).getVotos();
		} else {
			return "O número do partido informado não existe.";
		}		
	}
	
	public void criarCandidatos() {
		candidatos.add(new Candidato("Bento Ryan Renan Brito", "15", 0));
		candidatos.add(new Candidato("Leonardo Anthony da Luz", "30", 0));
	}
	
}
