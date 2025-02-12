package com.colegiointegracao.colegiointegracao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegiointegracao.colegiointegracao.model.Questao;
import com.colegiointegracao.colegiointegracao.repository.QuestaoRepository;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public Questao save(Questao questao) {
        return questaoRepository.save(questao);
    }

    public Questao update(Questao questao) {
        if (questao.getId() == null) {
            throw new IllegalArgumentException("ID cannot be null for update.");
        }
        Optional<Questao> existing = questaoRepository.findById(questao.getId());
        if (existing.isEmpty()) {
            throw new RuntimeException("Questao not found.");
        }
        return questaoRepository.save(questao);
    }

    public Questao findById(String id) {
        return questaoRepository.findById(id).orElse(null);
    }

    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    public void deleteById(String id) {
        questaoRepository.deleteById(id);
    }
}
