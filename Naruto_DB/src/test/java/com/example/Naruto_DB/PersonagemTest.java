package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Personagem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonagemTest {
    private Personagem personagem;

    @BeforeEach
    void setUp() {
        personagem = new Personagem("Naruto Uzumaki", 17, "Aldeia da Folha", 100);
    }

    @Test
    void testAdicionarJutsu() {
        personagem.adicionarNovoJutsu("Rasengan");
        assertEquals(1, personagem.getJutsus().size());
        assertTrue(personagem.getJutsus().contains("Rasengan"));
    }

    @Test
    void testAumentarChakra() {
        personagem.aumentarChakra(50);
        assertEquals(150, personagem.getChakra());
    }

    @Test
    void testExibirInformacoes() {
        personagem.exibirAsInformacoes();
    }
}
