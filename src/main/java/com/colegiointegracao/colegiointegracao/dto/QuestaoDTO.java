package com.colegiointegracao.colegiointegracao.dto;

import lombok.Data;
import java.util.List;

@Data
public class QuestaoDTO {

    private String id;
    private String tema;
    private String dificuldade;
    private String enunciado;
    private List<String> alternativas;
    private String resposta;
    private String autor;
    private String imagemId; // Campo para armazenar o ID da imagem no GridFS

    public QuestaoDTO() {
    }
}