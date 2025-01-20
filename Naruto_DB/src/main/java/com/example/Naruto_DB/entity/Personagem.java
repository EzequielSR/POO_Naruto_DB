package com.example.Naruto_DB.entity;

import com.example.Naruto_DB.ninja.Jutsu;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Personagem() {
        this.jutsus = new HashMap<>();
        this.chakra = 100;
    }

    public Personagem(String nome, int idade, String aldeia, int vida) {
        this();
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.vida = vida;
    }

    public void adicionarNovoJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {
        Optional<Jutsu> jutsuOpt = Optional.ofNullable(jutsus.get(nomeJutsu));

        if (jutsuOpt.isEmpty()) {
            System.out.println(nome + " não conhece o jutsu " + nomeJutsu + "!");
            return false;
        }

        Jutsu jutsu = jutsuOpt.get();
        if (chakra >= jutsu.getConsumoDeChakra()) {
            chakra -= jutsu.getConsumoDeChakra();
            inimigo.receberDano(jutsu.getDano());
            System.out.println(nome + " usou " + nomeJutsu + " em " + inimigo.getNome());
            return true;
        } else {
            System.out.println(nome + " não tem chakra suficiente para usar " + nomeJutsu + "!");
            return false;
        }
    }

    public void receberDano(int dano) {
        vida = Math.max(vida - dano, 0);
        System.out.println(getNome() + " recebeu " + dano + " de dano e agora tem " + vida + " de vida.");
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void desviar(int dano) {
        if (Math.random() > 0.5) {
            System.out.println(nome + " desviou do ataque!");
        } else {
            receberDano(dano);
        }
    }


    public String getNome() {
        return nome;
    }

    public int getChakra() {
        return chakra;
    }

    public Map<String, Jutsu> getJutsus() {
        return Collections.unmodifiableMap(jutsus);
    }


    public void setChakra(int chakra) {
        if (chakra < 0) {
            throw new IllegalArgumentException("Chakra não pode ser negativo.");
        }
        this.chakra = Math.min(chakra, 100);
    }

    public void aumentarChakra(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade a aumentar não pode ser negativa.");
        }
        setChakra(this.chakra + quantidade);
    }

    public void exibirAsInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus.keySet());
        System.out.println("Chakra: " + chakra);
        System.out.println("Vida: " + vida);
    }

}
