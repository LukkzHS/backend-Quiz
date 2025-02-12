package com.colegiointegracao.colegiointegracao.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class AtividadeDTO {
    private String id;
    private String nome;
    private Date data;
    private List<QuestaoDTO> questoes; // Alterado para lista de DTOs
    private String descricao;

    public AtividadeDTO() {
    }

}