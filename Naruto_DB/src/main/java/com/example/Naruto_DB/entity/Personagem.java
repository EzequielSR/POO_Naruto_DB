package com.example.Naruto_DB.entity;

import com.example.Naruto_DB.ninja.Jutsu;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Personagem {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private Map<String, Jutsu> jutsus;
    private int chakra;
    private int vida;

    public Personagem(String nome, int idade, String aldeia, int chakra, int vida) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = chakra;
        this.vida = vida;
        this.jutsus = new HashMap<>();
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

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public void setJutsus(Map<String, Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida(){
        return vida;
    }


    public void adicionarNovoJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu,jutsu);
    }

    public void aumentarChakra(int quantidade) {
        chakra += quantidade;
    }

    public void perderVida(int dano){
        vida -= dano;
        if(vida < 0){
            vida = 0;
        }
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    public boolean podeAtacar(){
        return chakra > 0;
    }

    public void exibirAsInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus);
        System.out.println("Chakra: " + chakra);
        System.out.println("Vida: " + vida);
    }
}
