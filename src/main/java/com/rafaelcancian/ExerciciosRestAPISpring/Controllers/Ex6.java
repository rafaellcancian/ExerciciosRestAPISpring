/*
 * 6 - Faça uma API que cadastre indivíduos do tipo Professor e Aluno, permitindo alteração e exclusão. 
 * A API deve ter uma consulta que liste todos os individuos cadastrados e outra que liste filtrando por tipo.
 */

package com.rafaelcancian.ExerciciosRestAPISpring.Controllers;

import java.util.ArrayList;
import java.util.List;
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

import com.rafaelcancian.ExerciciosRestAPISpring.Models.Pessoa;
import com.rafaelcancian.ExerciciosRestAPISpring.Repositories.PessoaRepository;

@RestController
@RequestMapping("/Ex6")
public class Ex6 {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{tipo}")
	public List<Pessoa> getPessoaTipo(@PathVariable String tipo) {
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		List<Pessoa> listaPessoasAux = new ArrayList<>();
		
		for (Pessoa p : listaPessoas) {
			if (tipo.equals(p.getTipo())) {
				listaPessoasAux.add(p);
			}
		}
		return listaPessoasAux;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa insertPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Pessoa updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		Pessoa p = pessoaRepository.getOne(id);
		
		if (p == null) {
			return null;
		}
		
		p.setNome(pessoa.getNome());
		p.setTipo(pessoa.getTipo());
		
		return pessoaRepository.save(p);
	}
	
}
