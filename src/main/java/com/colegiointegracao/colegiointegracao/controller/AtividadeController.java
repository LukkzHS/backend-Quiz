package com.colegiointegracao.colegiointegracao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegiointegracao.colegiointegracao.dto.AtividadeDTO;
import com.colegiointegracao.colegiointegracao.mapper.AtividadeMapper;
import com.colegiointegracao.colegiointegracao.model.Atividade;
import com.colegiointegracao.colegiointegracao.model.Questao;
import com.colegiointegracao.colegiointegracao.service.AtividadeService;
import com.colegiointegracao.colegiointegracao.service.QuestaoService;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private AtividadeMapper atividadeMapper;

    @Autowired
    private QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<AtividadeDTO> create(@RequestBody AtividadeDTO atividadeDTO) {
        Atividade atividade = atividadeMapper.toEntity(atividadeDTO);
        Atividade savedAtividade = atividadeService.save(atividade);
        return ResponseEntity.ok(atividadeMapper.toDTO(savedAtividade));
    }

    @PutMapping
    public ResponseEntity<AtividadeDTO> update(@RequestBody AtividadeDTO atividadeDTO) {
        Atividade atividade = atividadeMapper.toEntity(atividadeDTO);
        Atividade updatedAtividade = atividadeService.update(atividade);
        return ResponseEntity.ok(atividadeMapper.toDTO(updatedAtividade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeDTO> getById(@PathVariable String id) {
        Atividade atividade = atividadeService.findById(id);
        if (atividade == null) {
            return ResponseEntity.notFound().build();
        }
        // Resolver as referências das questões
        List<Questao> questoes = atividade.getQuestoes().stream()
                .map(ref -> questaoService.findById(ref.getId()))
                .collect(Collectors.toList());
        atividade.setQuestoes(questoes);
        return ResponseEntity.ok(atividadeMapper.toDTO(atividade));
    }

    @GetMapping
    public ResponseEntity<List<AtividadeDTO>> getAll() {
        List<Atividade> atividades = atividadeService.findAll();
        List<AtividadeDTO> atividadeDTOs = atividades.stream()
                .map(atividadeMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(atividadeDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        atividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}