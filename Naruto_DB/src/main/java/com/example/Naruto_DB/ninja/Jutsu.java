package com.example.Naruto_DB.ninja;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Jutsu {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int dano;
    private int consumoDeChakra;

    public Jutsu(String nome, int dano, int consumoDeChakra) {
        this.nome = nome;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }

    public int getDano() {
        return dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public String getNome() {
        return nome;
    }

}
