package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.ninja.Jutsu;
import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import com.example.Naruto_DB.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;

public class NinjaSimulator {
    public static void main(String[] args) {
        Personagem rockLee = new Personagem("Rock Lee", 17, "Aldeia da Folha", 100, 100);
        Personagem sasuke = new Personagem("Sasuke Uchiha", 17, "Aldeia da Folha", 100, 100);
        Personagem itachi = new Personagem("Itachi Uchiha", 21, "Aldeia da Folha", 100, 100);

        rockLee.adicionarNovoJutsu("Oito Portões", new Jutsu("Oito Portões", 100, 10));
        sasuke.adicionarNovoJutsu("Chidori", new Jutsu("Chidori", 90, 60));
        itachi.adicionarNovoJutsu("Tsukuyomi", new Jutsu("Tsukuyomi", 50, 20));

        System.out.println("\n--- INFORMAÇÕES INICIAIS ---\n");
        rockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
        sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
        itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");

        System.out.println("\n--- BATALHA COMEÇA ---\n");

        // Batalha entre Rock Lee e Itachi
        batalha(rockLee, itachi);

        // Se Itachi ainda estiver vivo, batalha entre Itachi e Rock Lee
        if (itachi.estaVivo()) {
            batalha(itachi, rockLee);
        }

        // Se Rock Lee ainda estiver vivo, batalha entre Sasuke e Rock Lee
        if (rockLee.estaVivo()) {
            batalha(sasuke, rockLee);
        }

        System.out.println("\n--- INFORMAÇÕES FINAIS ---\n");
        rockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
        sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
        itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");
    }


    private static void batalha(Personagem atacante, Personagem defensor) {
        String nomeJutsu = atacante.getJutsus().keySet().iterator().next();
        Jutsu jutsu = atacante.getJutsus().get(nomeJutsu);

        if (jutsu != null) {
            String NomeDoJutsu = atacante.getJutsus().keySet().iterator().next();
            Jutsu Jutsu = atacante.getJutsus().get(NomeDoJutsu);

            if (Jutsu != null) {
                System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + " com " + Jutsu.getNome() + "!");

                // Tentativa de desvio
                defensor.desviar(Jutsu.getDano());

                // Verifica se o defensor foi atingido
                if (!defensor.estaVivo()) {
                    System.out.println(defensor.getNome() + " foi derrotado!");
                }
            } else {
                System.out.println("Jutsu não encontrado para " + atacante.getNome());
            }
            System.out.println("-----------------------------");
        }
    }
}
