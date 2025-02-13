package com.example.Naruto_DB_PT_1.ninja;

import com.example.Naruto_DB_PT_1.personagem.Personagem;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int vida) {
        super(nome, idade, aldeia, vida);
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
