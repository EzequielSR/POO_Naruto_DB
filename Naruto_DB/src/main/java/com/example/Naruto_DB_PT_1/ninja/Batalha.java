package com.example.Naruto_DB_PT_1.ninja;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import com.example.Naruto_DB_PT_1.personagem.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Batalha {
    public void iniciarBatalha(Personagem atacante, Personagem defensor) {
        if (!atacante.estaVivo()) {
            System.out.println(atacante.getNome() + " está derrotado e não pode atacar!");
            return;
        }

        // Verifica se o defensor está vivo
        if (!defensor.estaVivo()) {
            System.out.println(defensor.getNome() + " está derrotado e não pode ser atacado!");
            return;
        }

        // Obtém a lista de jutsus do atacante
        List<Jutsu> jutsusDisponiveis = atacante.getJutsus();

        // Verifica se há jutsus disponíveis
        if (jutsusDisponiveis.isEmpty()) {
            System.out.println(atacante.getNome() + " não tem jutsus disponíveis para atacar!");
            return;
        }

        // Seleciona um jutsu aleatório da lista
        Jutsu jutsu = jutsusDisponiveis.get((int) (Math.random() * jutsusDisponiveis.size()));

        // Exibe o ataque
        System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + " com " + jutsu.getNome() + "!");

        // Verifica se o defensor desvia do ataque
        if (Math.random() < 0.5) {
            defensor.desviar(jutsu.getDano());
        } else {
            // Usa o jutsu no defensor
            if (atacante.usarJutsu(String.valueOf(jutsu), defensor)) {
                if (!defensor.estaVivo()) {
                    System.out.println(defensor.getNome() + " foi derrotado!");
                }
            }
        }

        System.out.println("-----------------------------");
    }
}
