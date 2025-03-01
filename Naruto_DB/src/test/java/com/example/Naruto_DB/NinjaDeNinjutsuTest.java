package com.example.Naruto_DB;

import com.example.Naruto_DB_PT_2.jutsu.Jutsu;
import com.example.Naruto_DB_PT_2.ninja.NinjaDeNinjutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NinjaDeNinjutsuTest {
    private NinjaDeNinjutsu personagem;

    @BeforeEach
    public void setUp(){
        personagem = new NinjaDeNinjutsu("Naruto Uzumaki", 17, "Aldeia da Folha", 100);
    }

    @Test
    public void testAdicionarJutsu(){
        Jutsu jutsu = new Jutsu("Rasengan",50,10);
        personagem.adicionarNovoJutsu("Rasengan", jutsu);
        assertEquals(1, personagem.getJutsus().size());
        assertTrue(personagem.getJutsus().containsKey("Rasengan"));
        assertEquals(jutsu, personagem.getJutsus().get("Rasengan"));
    }

   @Test
    void testExibirInformacoes(){
        personagem.exibirAsInformacoes();
   }

}
