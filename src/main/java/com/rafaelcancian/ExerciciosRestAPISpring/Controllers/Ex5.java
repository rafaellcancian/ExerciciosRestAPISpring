/*
 * 5 - Faça uma API que cadastre a população de uma cidade para cada ano:
 * Exemplo:
 * 2006 - 145842
 * 2007 - 146254
 * ...
 * A Api deve permitir alteração e exclusão dos valores. Além de uma consulta geral e outra por ano.
*/

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelcancian.ExerciciosRestAPISpring.Models.Populacao;
import com.rafaelcancian.ExerciciosRestAPISpring.Repositories.PopulacaoRepository;

@RestController
@RequestMapping("/Ex5")
public class Ex5 {
	@Autowired
	private PopulacaoRepository populacaoRepository;
	
	@GetMapping
	public List<Populacao> getPopulacao() {
		return populacaoRepository.findAll();
	}
	
	@GetMapping("/{ano}")
	public Optional<Populacao> getPopulacaoAno(@PathVariable String ano) {
		return populacaoRepository.findById(ano);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Populacao insertPopulacao(@RequestBody Populacao populacao) {
		return populacaoRepository.save(populacao);
	}
	
	@DeleteMapping("/{ano}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePopulacao(@PathVariable String ano) {
		populacaoRepository.deleteById(ano);
	}
	
	@PutMapping("/{ano}")
	public Populacao updatePopulacao(@RequestBody Populacao populacao, @PathVariable String ano) {
		Populacao p = populacaoRepository.getOne(ano);
		
		if (p == null) {
			return null;
		}
		
		p.setPopulacao(populacao.getPopulacao());
		
		return populacaoRepository.save(p);
	}
	
}
