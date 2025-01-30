package com.example.Naruto_DB.jutsu;

import com.example.Naruto_DB.personagem.Personagem;
import jakarta.persistence.*;

@Entity
public class Jutsu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int dano;
    private int consumoDeChakra;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    public Jutsu() {
    }

    public Jutsu(String nome, int dano, int consumoDeChakra) {
        if (dano < 0) {
            throw new IllegalArgumentException("Dano não pode ser negativo.");
        }
        if (consumoDeChakra < 0) {
            throw new IllegalArgumentException("Consumo de chakra não pode ser negativo.");
        }

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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean usar(Personagem atacante, Personagem defensor) {
        if (atacante.getChakra() >= consumoDeChakra) {
            atacante.setChakra(atacante.getChakra() - consumoDeChakra);
            defensor.receberDano(dano);
            return true;
        } else {
            System.out.println(atacante.getNome() + " não tem chakra suficiente!");
            return false;
        }
    }

}
