package com.example.Naruto_DB_PT_1.ninja;

import com.example.Naruto_DB_PT_1.personagem.Personagem;

public interface Ninja {
    boolean usarJutsu(String nomeJutsu, Personagem inimigo);

    void desviar(int dano);
}
