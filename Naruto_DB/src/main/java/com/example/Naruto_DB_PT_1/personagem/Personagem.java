package com.example.Naruto_DB_PT_1.personagem;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<Jutsu> jutsus = new ArrayList<>();

    public Personagem(){}

    public Personagem(Long id, String nome, int idade, String aldeia, int chakra, int vida, List<Jutsu> jutsus) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = chakra;
        this.vida = vida;
        this.jutsus = jutsus;
    }

    public Personagem(String nome, int idade, String aldeia, int vida) {
    }


    public void adicionarNovoJutsu(Jutsu jutsu) {
        jutsu.setPersonagem(this);
        jutsus.add(jutsu);
    }

    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {
        Jutsu jutsu = jutsus.stream()
                .filter(j -> j.getNome().equalsIgnoreCase(nomeJutsu))
                .findFirst()
                .orElse(null);

        if (jutsu == null) {
            System.out.println(nome + " não conhece o jutsu " + nomeJutsu + "!");
            return false;
        }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setJutsus(List<Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public List<Jutsu> getJutsus() {
        return jutsus;
    }


    public void setChakra(int chakra) {
        if (chakra < 0) {
            throw new IllegalArgumentException("Chakra não pode ser negativo.");
        }
        this.chakra = Math.min(chakra, 100);
    }



    public void exibirAsInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus.stream().map(Jutsu::getNome).toList());
        System.out.println("Chakra: " + chakra);
        System.out.println("Vida: " + vida);
    }

}