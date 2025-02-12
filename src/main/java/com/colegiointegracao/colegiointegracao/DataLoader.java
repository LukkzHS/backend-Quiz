package com.colegiointegracao.colegiointegracao;

import com.colegiointegracao.colegiointegracao.model.Atividade;
import com.colegiointegracao.colegiointegracao.model.Questao;
import com.colegiointegracao.colegiointegracao.repository.AtividadeRepository;
import com.colegiointegracao.colegiointegracao.repository.QuestaoRepository;
import com.colegiointegracao.colegiointegracao.service.GridFsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private GridFsService gridFsService;

    @Override
    public void run(String... args) throws Exception {
        // Criação das questões
        Questao questao1 = new Questao();
        questao1.setTema("Matemática");
        questao1.setDificuldade("Fácil");
        questao1.setEnunciado("Quanto é 2 + 2?");
        questao1.setAlternativas(Arrays.asList("2", "3", "4", "5"));
        questao1.setResposta("4");
        questao1.setAutor("Professor A");
        questao1.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao2 = new Questao();
        questao2.setTema("Matemática");
        questao2.setDificuldade("Fácil");
        questao2.setEnunciado("Quantos lados tem um triângulo?");
        questao2.setAlternativas(Arrays.asList("2", "3", "4", "5"));
        questao2.setResposta("3");
        questao2.setAutor("Professor A");
        questao2.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao3 = new Questao();
        questao3.setTema("Ciências");
        questao3.setDificuldade("Fácil");
        questao3.setEnunciado("Qual parte do corpo usamos para cheirar?");
        questao3.setAlternativas(Arrays.asList("Olhos", "Ouvidos", "Nariz", "Boca"));
        questao3.setResposta("Nariz");
        questao3.setAutor("Professor B");
        questao3.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao4 = new Questao();
        questao4.setTema("História");
        questao4.setDificuldade("Fácil");
        questao4.setEnunciado("Quem foi o primeiro presidente do Brasil?");
        questao4.setAlternativas(Arrays.asList("Getúlio Vargas", "Deodoro da Fonseca", "Juscelino Kubitschek", "Fernando Henrique Cardoso"));
        questao4.setResposta("Deodoro da Fonseca");
        questao4.setAutor("Professor B");
        questao4.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao5 = new Questao();
        questao5.setTema("Geografia");
        questao5.setDificuldade("Fácil");
        questao5.setEnunciado("Qual é a capital do Brasil?");
        questao5.setAlternativas(Arrays.asList("Rio de Janeiro", "Brasília", "São Paulo", "Salvador"));
        questao5.setResposta("Brasília");
        questao5.setAutor("Professor C");
        questao5.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao6 = new Questao();
        questao6.setTema("Matemática");
        questao6.setDificuldade("Fácil");
        questao6.setEnunciado("Quanto é 5 - 2?");
        questao6.setAlternativas(Arrays.asList("3", "4", "2", "1"));
        questao6.setResposta("3");
        questao6.setAutor("Professor A");
        questao6.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao7 = new Questao();
        questao7.setTema("Ciências");
        questao7.setDificuldade("Fácil");
        questao7.setEnunciado("Qual astro ilumina o dia?");
        questao7.setAlternativas(Arrays.asList("Lua", "Estrela", "Sol", "Marte"));
        questao7.setResposta("Sol");
        questao7.setAutor("Professor B");
        questao7.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao8 = new Questao();
        questao8.setTema("Geografia");
        questao8.setDificuldade("Fácil");
        questao8.setEnunciado("Qual é o maior oceano do planeta?");
        questao8.setAlternativas(Arrays.asList("Atlântico", "Índico", "Pacífico", "Ártico"));
        questao8.setResposta("Pacífico");
        questao8.setAutor("Professor C");
        questao8.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao9 = new Questao();
        questao9.setTema("História");
        questao9.setDificuldade("Fácil");
        questao9.setEnunciado("Em que ano o Brasil foi descoberto?");
        questao9.setAlternativas(Arrays.asList("1492", "1500", "1600", "1700"));
        questao9.setResposta("1500");
        questao9.setAutor("Professor B");
        questao9.setImagemId(storeImage("image\\teste2.jpg"));

        Questao questao10 = new Questao();
        questao10.setTema("Matemática");
        questao10.setDificuldade("Fácil");
        questao10.setEnunciado("Quanto é 10 dividido por 2?");
        questao10.setAlternativas(Arrays.asList("4", "5", "6", "3"));
        questao10.setResposta("5");
        questao10.setAutor("Professor A");
        questao10.setImagemId(storeImage("image\\teste2.jpg"));

        // Salvar questões no MongoDB
        questaoRepository.saveAll(Arrays.asList(questao1, questao2, questao3, questao4, questao5, questao6, questao7, questao8, questao9, questao10));

        // Criação da atividade
        Atividade atividade = new Atividade();
        atividade.setNome("Atividade de Teste para Crianças");
        atividade.setData(new Date());
        atividade.setQuestoes(Arrays.asList(questao1, questao2, questao3, questao4, questao5, questao6, questao7, questao8, questao9, questao10));
        atividade.setDescricao("Descrição da atividade com perguntas simples para crianças");

        // Salvar atividade no MongoDB
        atividadeRepository.save(atividade);
    }

    private String storeImage(String imagePath) throws Exception {
        File file = new File(imagePath);
        if (!file.exists()) {
            System.err.println("Arquivo não encontrado: " + imagePath);
            return null;
        }
    
        try (InputStream inputStream = new FileInputStream(imagePath)) {
            ObjectId imageId = gridFsService.storeFile(
                    inputStream,
                    "imagem-questao-" + System.currentTimeMillis() + ".jpg", // Nome único
                    "image/jpeg");
            return imageId.toHexString();
        } catch (Exception e) {
            System.err.println("Erro ao salvar imagem: " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
}
