package com.colegiointegracao.colegiointegracao.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "atividades")
public class Atividade {

    @Id
    private String id;
    private String nome;
    private Date data;

    // Relacionamento 1-N: uma Atividade pode ter várias Questões
    @DBRef
    private List<Questao> questoes;

    // Atributo extra
    private String descricao;

    public Atividade() {
    }
}
