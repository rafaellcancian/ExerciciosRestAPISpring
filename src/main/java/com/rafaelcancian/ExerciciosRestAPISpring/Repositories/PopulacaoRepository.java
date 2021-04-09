package com.rafaelcancian.ExerciciosRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelcancian.ExerciciosRestAPISpring.Models.Populacao;

@Repository
public interface PopulacaoRepository extends JpaRepository<Populacao, String> {

}
