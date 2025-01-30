package com.example.Naruto_DB.personagem;

import com.example.Naruto_DB.jutsu.JutsuDTO;

import java.util.Map;

public class PersonagemDTO {
    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private int vida;
    private Map<String, JutsuDTO> jutsus;

    public PersonagemDTO(Long id, String nome, int idade, String aldeia, int chakra, int vida, Map<String, JutsuDTO> jutsus) {
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

    public Map<String, JutsuDTO> getJutsus() {
        return jutsus;
    }

    public void setJutsus(Map<String, JutsuDTO> jutsus) {
        this.jutsus = jutsus;
    }

    public PersonagemDTO() {
    }


}
