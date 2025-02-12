package com.colegiointegracao.colegiointegracao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegiointegracao.colegiointegracao.model.Questao;
import com.colegiointegracao.colegiointegracao.service.QuestaoService;

@RestController
@RequestMapping("/api/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @PostMapping
    public Questao create(@RequestBody Questao questao) {
        return questaoService.save(questao);
    }

    @PutMapping
    public Questao update(@RequestBody Questao questao) {
        return questaoService.update(questao);
    }

    @GetMapping("/{id}")
    public Questao getById(@PathVariable String id) {
        return questaoService.findById(id);
    }

    @GetMapping
    public List<Questao> getAll() {
        return questaoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        questaoService.deleteById(id);
    }
}
