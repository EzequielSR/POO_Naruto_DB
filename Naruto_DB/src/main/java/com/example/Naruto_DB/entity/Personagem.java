package com.example.Naruto_DB.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Personagem {
    @Id
    @GeneratedValue
    private String nome;
    private int idade;
    private String aldeia;
    private ArrayList<String> jutsus;
    private int chakra;

    public Personagem(String nome, int idade, String aldeia, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = chakra;
        this.jutsus = new ArrayList<>();
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

    public ArrayList<String> getJutsus() {
        return jutsus;
    }

    public void setJutsus(ArrayList<String> jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }


    public void adicionarNovoJutsu(String jutsu) {
        jutsus.add(jutsu);
    }

    public void aumentarChakra(int quantidade) {
        chakra += quantidade;
    }

    public void exibirAsInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus);
        System.out.println("Chakra: " + chakra);
    }
}
