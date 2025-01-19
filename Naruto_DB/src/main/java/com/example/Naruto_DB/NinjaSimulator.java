package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.ninja.Jutsu;
import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import com.example.Naruto_DB.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;

public class NinjaSimulator {
    public static void main(String[] args) {
        Personagem rockLee = new Personagem("Rock Lee", 17, "Aldeia da Folha", 100);
        Personagem sasuke = new Personagem("Sasuke Uchiha", 17, "Aldeia da Folha", 100);
        Personagem itachi = new Personagem("Itachi Uchiha", 21, "Aldeia da Folha", 100);

        rockLee.adicionarNovoJutsu("Oito Portões", new Jutsu("Oito Portões", 100, 100));
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


        batalha(rockLee, itachi);


        if (itachi.estaVivo()) {
            batalha(itachi, rockLee);
        }


        if (rockLee.estaVivo()) {
            batalha(sasuke, rockLee);
        }

        if (sasuke.estaVivo()) {
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
            System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + " com " + jutsu.getNome() + "!");

            if (Math.random() < 0.5) {
                System.out.println(defensor.getNome() + " desviou do ataque!");
            } else {
                if (jutsu.usar(atacante, defensor)) {
                    if (!defensor.estaVivo()) {
                        System.out.println(defensor.getNome() + " foi derrotado!");
                    }
                }
            }
        } else {
            System.out.println("Jutsu não encontrado para " + atacante.getNome());
        }
        System.out.println("-----------------------------");
    }
}
