package com.rafaelcancian.ExerciciosRestAPISpring.Models;

public class Candidato {
	private String nome;
	private String numPartido;
	private int votos;
	
	public Candidato(String nome, String numPartido, int votos) {
		this.nome = nome;
		this.numPartido = numPartido;
		this.votos = votos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumPartido() {
		return numPartido;
	}
	
	public void setNumPartido(String partido) {
		this.numPartido = partido;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
}
