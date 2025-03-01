package com.example.Naruto_DB;

import com.example.Naruto_DB_PT_2.ninja.Batalha;
import com.example.Naruto_DB_PT_2.jutsu.Jutsu;
import com.example.Naruto_DB_PT_2.ninja.NinjaDeNinjutsu;
import com.example.Naruto_DB_PT_2.ninja.NinjaDeTaijutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BatalhaTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testLutar() {
        NinjaDeTaijutsu ninja1 = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 100);
        NinjaDeNinjutsu ninja2 = new NinjaDeNinjutsu("Sasuke Uchiha", 17, "Aldeia da Folha", 100);

        Jutsu jutsu1 = new Jutsu("Oito Portões", 100, 100);
        ninja1.adicionarNovoJutsu("Oito Portões", jutsu1);

        Jutsu jutsu2 = new Jutsu("Chidori", 90, 60);
        ninja2.adicionarNovoJutsu("Chidori", jutsu2);

        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(ninja1, ninja2);

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("Rock Lee ataca Sasuke Uchiha com Oito Portões!") ||
                output.contains("Sasuke Uchiha ataca Rock Lee com Chidori!"));
        assertTrue(output.contains("foi derrotado!") || output.contains("desviou!"));
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOut);
    }

}
