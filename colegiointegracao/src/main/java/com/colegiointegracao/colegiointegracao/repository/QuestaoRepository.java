package com.colegiointegracao.colegiointegracao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.colegiointegracao.colegiointegracao.model.Questao;

@Repository
public interface QuestaoRepository extends MongoRepository<Questao, String> {
}
