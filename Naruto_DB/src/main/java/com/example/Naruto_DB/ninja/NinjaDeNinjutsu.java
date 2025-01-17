package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int chakra){
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Ninjutsu!");

    }

    @Override
    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Ninjutsu!");
    }
}
