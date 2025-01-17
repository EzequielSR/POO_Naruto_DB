package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

public class NinjaDeGenjutsu extends Personagem implements Ninja {
    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra){
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void usarJutsu(){
        System.out.println(getNome() + " está usando um jutsu de Genjutsu!");
    }

    @Override
    public void desviar(){
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Genjutsu!");
    }
}
