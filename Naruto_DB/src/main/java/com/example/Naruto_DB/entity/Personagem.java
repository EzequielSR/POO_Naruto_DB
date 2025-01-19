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

    public Personagem(String nome, int idade, String aldeia, int vida) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = 100;
        this.vida = vida;
        this.jutsus = new HashMap<>();
    }

    public void adicionarNovoJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {

        Jutsu jutsu = jutsus.get(nomeJutsu);
        if (jutsu != null && chakra >= jutsu.getConsumoDeChakra()) {
            chakra -= jutsu.getConsumoDeChakra();
            inimigo.receberDano(jutsu.getDano());
            System.out.println(nome + " usou " + nomeJutsu + " e causou " + jutsu.getDano() + " de dano!");
            return true;
        } else {
            System.out.println(nome + " não tem chakra suficiente para usar " + nomeJutsu + "!");
            return false;
        }
    }

    public void desviar(int dano) {
        if (Math.random() > 0.5) {
            System.out.println(nome + " desviou do ataque!");
        } else {
            vida -= dano;
            System.out.println(nome + " foi atingido e perdeu " + dano + " de vida!");
        }
    }

    public void receberDano(int dano) {
        vida -= dano;
        if(vida < 0){
            vida = 0;
        }
        System.out.println(getNome() + " recebeu " + dano + " de dano e agora tem " + vida + " de vida.");
    }


    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public void exibirAsInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus.keySet());
        System.out.println("Chakra: " + chakra);
        System.out.println("Vida: " + vida);
    }

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }
}
