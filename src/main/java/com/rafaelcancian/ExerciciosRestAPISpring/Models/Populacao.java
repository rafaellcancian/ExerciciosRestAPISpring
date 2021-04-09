package com.rafaelcancian.ExerciciosRestAPISpring.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Populacao {
	
	@Id
	@Column(nullable = false)
	private String ano;
	
	@Column(nullable = false)
	private int populacao;
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public int getPopulacao() {
		return populacao;
	}
	
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
}
