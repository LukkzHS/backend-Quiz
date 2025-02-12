package com.colegiointegracao.colegiointegracao.mapper;

import org.springframework.stereotype.Component;

import com.colegiointegracao.colegiointegracao.dto.QuestaoDTO;
import com.colegiointegracao.colegiointegracao.model.Questao;

@Component
public class QuestaoMapper {

    public QuestaoDTO toDTO(Questao questao) {
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

    public Questao toEntity(QuestaoDTO dto) {
        Questao questao = new Questao();
        questao.setId(dto.getId());
        questao.setTema(dto.getTema());
        questao.setDificuldade(dto.getDificuldade());
        questao.setEnunciado(dto.getEnunciado());
        questao.setAlternativas(dto.getAlternativas());
        questao.setResposta(dto.getResposta());
        questao.setAutor(dto.getAutor());
        questao.setImagemId(dto.getImagemId());
        return questao;
    }
}