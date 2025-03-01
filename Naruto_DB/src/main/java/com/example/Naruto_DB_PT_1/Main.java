package com.example.Naruto_DB_PT_1;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import com.example.Naruto_DB_PT_1.ninja.Batalha;
import com.example.Naruto_DB_PT_1.ninja.NinjaDeGenjutsu;
import com.example.Naruto_DB_PT_1.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB_PT_1.ninja.NinjaDeTaijutsu;

public class Main {
    public static void main(String[] args) {
        NinjaDeTaijutsu rockLee = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 100);
        NinjaDeNinjutsu sasuke = new NinjaDeNinjutsu("Sasuke Uchiha", 17, "Aldeia da Folha", 100);
        NinjaDeGenjutsu itachi = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 100);

        rockLee.adicionarNovoJutsu( new Jutsu("Oito Portões", 100, 100));
        sasuke.adicionarNovoJutsu( new Jutsu("Chidori", 90, 60));
        itachi.adicionarNovoJutsu( new Jutsu("Tsukuyomi", 50, 20));

        System.out.println("\n--- INFORMAÇÕES INICIAIS ---\n");
        rockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
        sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
        itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");

        System.out.println("\n--- BATALHA COMEÇA ---\n");

        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(rockLee, itachi);


        if (itachi.estaVivo()) {
            batalha.iniciarBatalha(itachi, rockLee);
        }

        if (rockLee.estaVivo()) {
            batalha.iniciarBatalha(sasuke, rockLee);
        }

        System.out.println("\n--- INFORMAÇÕES FINAIS ---\n");
        rockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
        sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
        itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");
    }
}
