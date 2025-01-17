package com.example.Naruto_DB.principal;

import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import com.example.Naruto_DB.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;

public class Principal {
    public static void main(String[] args) {
        NinjaDeGenjutsu itachi = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 100);
        itachi.adicionarNovoJutsu("Tsukuyomi");
        itachi.aumentarChakra(20);
        itachi.exibirAsInformacoes();
        itachi.usarJutsu();
        itachi.desviar();

        System.out.println("\n##################################\n");

        NinjaDeNinjutsu sasuke = new NinjaDeNinjutsu("Sasuke Uchiha", 17, "Aldeia da Folha", 100);
        sasuke.adicionarNovoJutsu("Chidori");
        sasuke.aumentarChakra(30);
        sasuke.exibirAsInformacoes();
        sasuke.usarJutsu();
        sasuke.desviar();

        System.out.println("\n##################################\n");


        NinjaDeTaijutsu rockLee = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 100);
        rockLee.adicionarNovoJutsu("Oito Portões");
        rockLee.adicionarNovoJutsu("Leaf Whirlwind");
        rockLee.aumentarChakra(50);
        rockLee.exibirAsInformacoes();
        rockLee.usarJutsu();
        rockLee.desviar();
    }
}
