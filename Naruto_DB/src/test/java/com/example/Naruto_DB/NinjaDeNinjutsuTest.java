package com.example.Naruto_DB;

import com.example.Naruto_DB.ninja.NinjaDeNinjutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NinjaDeNinjutsuTest {
    private NinjaDeNinjutsu ninjaDeNinjutsu;

    @BeforeEach
    public void setUp(){
        ninjaDeNinjutsu = new NinjaDeNinjutsu("Naruto Uzumaki", 17, "Aldeia da Folha", 500);
    }

    @Test
    public void testUsarJutsu(){
        ninjaDeNinjutsu.usarJutsu();
    }

    @Test
    public void testDesviar(){
        ninjaDeNinjutsu.desviar();
    }

    @Test
    public void testAdicionarJutsu(){
        ninjaDeNinjutsu.adicionarNovoJutsu("Rasengan");
        assertTrue(ninjaDeNinjutsu.getJutsus().contains("Rasengan"));
    }

    @Test
    public void testAumentarChakra(){
        ninjaDeNinjutsu.aumentarChakra(100);
        assertEquals(600, ninjaDeNinjutsu.getChakra());
    }
}
