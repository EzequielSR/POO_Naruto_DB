package com.example.Naruto_DB_PT_1.personagem;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import com.example.Naruto_DB_PT_1.jutsu.JutsuDTO;

import java.util.List;
import java.util.Map;

public class PersonagemDTO {
    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private int vida;
    private List<JutsuDTO> jutsus;

    public PersonagemDTO(Long id, String nome, int idade, String aldeia, int chakra, int vida, List<JutsuDTO> jutsus) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = chakra;
        this.vida = vida;
        this.jutsus = jutsus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public List<JutsuDTO> getJutsus() {
        return jutsus;
    }

    public void setJutsus(List<JutsuDTO> jutsus) {
        this.jutsus = jutsus;
    }

    public void atualizarChakra(int novoChakra){
        this.chakra = novoChakra;
    }

    public PersonagemDTO() {}


}
