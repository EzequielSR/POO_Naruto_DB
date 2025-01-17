package com.example.Naruto_DB;

import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NinjaDeGenjutsuTest {
    private NinjaDeGenjutsu ninja;

    @BeforeEach
    public void setUp() {
        ninja = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 300);
    }

    @Test
    public void testUsarJutsu() {
        ninja.usarJutsu();
    }

    @Test
    public void testDesviar() {
        ninja.desviar();
    }

    @Test
    public void testAdicionarJutsu() {
        ninja.adicionarNovoJutsu("Tsukuyomi");
        assertTrue(ninja.getJutsus().contains("Tsukuyomi"));
    }

    @Test
    public void testAumentarChakra() {
        ninja.aumentarChakra(70);
        assertEquals(370, ninja.getChakra());
    }

}
