package com.colegiointegracao.colegiointegracao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.colegiointegracao.colegiointegracao.dto.AtividadeDTO;
import com.colegiointegracao.colegiointegracao.dto.QuestaoDTO;
import com.colegiointegracao.colegiointegracao.model.Atividade;
import com.colegiointegracao.colegiointegracao.model.Questao;

@Component
public class AtividadeMapper {

    public AtividadeDTO toDTO(Atividade entity) {
        if (entity == null) {
            return null;
        }
        
        AtividadeDTO dto = new AtividadeDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setData(entity.getData());
        dto.setDescricao(entity.getDescricao());
        dto.setQuestoes(mapQuestoesToDTO(entity.getQuestoes()));
        
        return dto;
    }

    private List<QuestaoDTO> mapQuestoesToDTO(List<Questao> questoes) {
        return questoes.stream()
                .map(this::mapQuestaoToDTO)
                .collect(Collectors.toList());
    }

    private QuestaoDTO mapQuestaoToDTO(Questao questao) {
        if (questao == null) {
            return null;
        }
        QuestaoDTO dto = new QuestaoDTO();
        dto.setId(questao.getId());
        dto.setTema(questao.getTema());
        dto.setDificuldade(questao.getDificuldade());
        dto.setEnunciado(questao.getEnunciado());
        dto.setAlternativas(questao.getAlternativas());
        dto.setResposta(questao.getResposta());
        dto.setAutor(questao.getAutor());
        dto.setImagemId(questao.getImagemId()); 
        return dto;
    }

    public Atividade toEntity(AtividadeDTO dto) {
        if (dto == null) {
            return null;
        }
        Atividade entity = new Atividade();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setData(dto.getData());
        entity.setDescricao(dto.getDescricao());
        entity.setQuestoes(mapQuestoesToEntity(dto.getQuestoes()));
        return entity;
    }

    private List<Questao> mapQuestoesToEntity(List<QuestaoDTO> questoes) {
        return questoes.stream()
                .map(this::mapQuestaoToEntity)
                .collect(Collectors.toList());
    }

    private Questao mapQuestaoToEntity(QuestaoDTO dto) {
        if (dto == null) {
            return null;
        }
        Questao entity = new Questao();
        entity.setId(dto.getId());
        entity.setTema(dto.getTema());
        entity.setDificuldade(dto.getDificuldade());
        entity.setEnunciado(dto.getEnunciado());
        entity.setAlternativas(dto.getAlternativas());
        entity.setResposta(dto.getResposta());
        entity.setAutor(dto.getAutor());
        entity.setImagemId(dto.getImagemId());
        return entity;
    }
}