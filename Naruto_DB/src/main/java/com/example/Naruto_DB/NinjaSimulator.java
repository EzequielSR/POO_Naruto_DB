package com.example.Naruto_DB;

import com.example.Naruto_DB.ninja.Jutsu;
import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import com.example.Naruto_DB.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;

public class NinjaSimulator {
    public static void main(String[] args) {
          NinjaDeTaijutsu RockLee = new NinjaDeTaijutsu("RockLee", 17, "Aldeia da Folha", 150);
          NinjaDeNinjutsu Sasuke = new NinjaDeNinjutsu("Sasuke", 17, "Aldeia da Folha", 50);
          NinjaDeGenjutsu Itachi = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 100);

          RockLee.adicionarNovoJutsu("Oito portões", new Jutsu(100,10));
          Sasuke.adicionarNovoJutsu("Chidori", new Jutsu(40,60));
          Itachi.adicionarNovoJutsu("Tsukuyomi", new Jutsu(50,20));

        System.out.println("\n--- INFORMAÇÕES INICIAIS ---\n");
          RockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
          Sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
          Itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");

        System.out.println("\n--- BATALHA COMEÇA ---\n");

        RockLee.usarJutsu(Itachi,"Oito portões");
        Itachi.desviar(100);
        if(!Itachi.estaVivo()){
            System.out.println("Itachi foi derrotado!");
        }
        System.out.println("-----------------------------");


        if(Itachi.estaVivo()){
        Itachi.usarJutsu(RockLee, "Tsukuyomi");
        RockLee.desviar(50);
            if(!RockLee.estaVivo()){
                System.out.println("Rock Lee foi derrotado!");
            }

        System.out.println("-----------------------------");
        }

        if(RockLee.estaVivo()){
        Sasuke.usarJutsu(RockLee, "Chidori");
        RockLee.desviar(40);
        if(!RockLee.estaVivo()){
            System.out.println("Rock Lee foi derrotado!");
        }

        System.out.println("-----------------------------");
        }

        System.out.println("\n--- INFORMAÇÕES FINAIS ---\n");
        RockLee.exibirAsInformacoes();
        System.out.println("-----------------------------");
        Sasuke.exibirAsInformacoes();
        System.out.println("-----------------------------");
        Itachi.exibirAsInformacoes();
        System.out.println("-----------------------------");

//        NinjaDeGenjutsu itachi = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 100);
//        itachi.adicionarNovoJutsu("Tsukuyomi");
//        itachi.aumentarChakra(20);
//        itachi.exibirAsInformacoes();
//        itachi.usarJutsu();
//        itachi.desviar();
//
//        System.out.println("\n##################################\n");
//
//        NinjaDeNinjutsu sasuke = new NinjaDeNinjutsu("Sasuke Uchiha", 17, "Aldeia da Folha", 100);
//        sasuke.adicionarNovoJutsu("Chidori");
//        sasuke.aumentarChakra(30);
//        sasuke.exibirAsInformacoes();
//        sasuke.usarJutsu();
//        sasuke.desviar();
//
//        System.out.println("\n##################################\n");
//
//
//        NinjaDeTaijutsu rockLee = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 100);
//        rockLee.adicionarNovoJutsu("Oito Portões");
//        rockLee.adicionarNovoJutsu("Leaf Whirlwind");
//        rockLee.aumentarChakra(50);
//        rockLee.exibirAsInformacoes();
//        rockLee.usarJutsu();
//        rockLee.desviar();
    }
}
