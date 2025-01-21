package com.example.Naruto_DB.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private int vida;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, PersonagemJutsu> jutsus = new HashMap<>();

    public Personagem() {
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
        PersonagemJutsu personagemJutsu = new PersonagemJutsu(this, jutsu, nomeJutsu);
        jutsus.put(nomeJutsu, personagemJutsu);
    }

    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {
        PersonagemJutsu personagemJutsu = jutsus.get(nomeJutsu);

        if (personagemJutsu == null) {
            System.out.println(nome + " não conhece o jutsu " + nomeJutsu + "!");
            return false;
        }

        Jutsu jutsu = personagemJutsu.getJutsu();
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

    public Map<String, PersonagemJutsu> getJutsus() {
        return new HashMap<>(jutsus);
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
