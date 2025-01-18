package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

public interface Ninja {
    void usarJutsu(Personagem inimigo, String nomeJutsu);
    void desviar(int dano);
}
