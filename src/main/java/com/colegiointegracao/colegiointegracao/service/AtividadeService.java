package com.colegiointegracao.colegiointegracao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegiointegracao.colegiointegracao.model.Atividade;
import com.colegiointegracao.colegiointegracao.repository.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Atividade update(Atividade atividade) {
        if (atividade.getId() == null) {
            throw new IllegalArgumentException("ID cannot be null for update.");
        }
        Optional<Atividade> existing = atividadeRepository.findById(atividade.getId());
        if (existing.isEmpty()) {
            throw new RuntimeException("Atividade not found.");
        }
        return atividadeRepository.save(atividade);
    }

    public Atividade findById(String id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public void deleteById(String id) {
        atividadeRepository.deleteById(id);
    }
}
