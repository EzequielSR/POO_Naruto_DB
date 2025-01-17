package com.example.Naruto_DB;

import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NinjaDeTaijutsuTest {
    private NinjaDeTaijutsu ninja;

    @BeforeEach
    public void setUp() {
        ninja = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 200);
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
        ninja.adicionarNovoJutsu("Dynamic Entry");
        assertTrue(ninja.getJutsus().contains("Dynamic Entry"));
    }

    @Test
    public void testAumentarChakra() {
        ninja.aumentarChakra(50);
        assertEquals(250, ninja.getChakra());
    }

}
