package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.personagem.Personagem;

public interface Ninja {
    boolean usarJutsu(String nomeJutsu, Personagem inimigo);

    void desviar(int dano);
}
