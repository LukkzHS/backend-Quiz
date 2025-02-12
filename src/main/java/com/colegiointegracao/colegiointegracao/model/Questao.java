package com.colegiointegracao.colegiointegracao.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "questoes")
public class Questao {
    @Id
    private String id;
    private String tema;
    private String dificuldade;
    private String enunciado;
    private List<String> alternativas;
    private String resposta;
    private String autor;
    private String imagemId; // Deve corresponder ao nome do campo
}