package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

import java.util.Random;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int chakra, int vida){
        super(nome, idade, aldeia, chakra, vida);
    }

    @Override
    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {
        return super.usarJutsu(nomeJutsu, inimigo);

    }

    @Override
    public void desviar(int dano) {
       super.desviar(dano);
    }
}
