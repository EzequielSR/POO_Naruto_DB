package com.example.Naruto_DB.entity;

import jakarta.persistence.*;

@Entity
public class PersonagemJutsu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "jutsu_id", nullable = false)
    private Jutsu jutsu;

    private String nomeJutsu; // Chave do mapa

    public PersonagemJutsu() {}

    public PersonagemJutsu(Personagem personagem, Jutsu jutsu, String nomeJutsu) {
        this.personagem = personagem;
        this.jutsu = jutsu;
        this.nomeJutsu = nomeJutsu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Jutsu getJutsu() {
        return jutsu;
    }

    public void setJutsu(Jutsu jutsu) {
        this.jutsu = jutsu;
    }

    public String getNomeJutsu() {
        return nomeJutsu;
    }

    public void setNomeJutsu(String nomeJutsu) {
        this.nomeJutsu = nomeJutsu;
    }
}
