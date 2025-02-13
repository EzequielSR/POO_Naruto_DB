package com.example.Naruto_DB_PT_2.ninja;

import com.example.Naruto_DB_PT_2.personagem.Personagem;

public interface Ninja {
    boolean usarJutsu(String nomeJutsu, Personagem inimigo);

    void desviar(int dano);
}
