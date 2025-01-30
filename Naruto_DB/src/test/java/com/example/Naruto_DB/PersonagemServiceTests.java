package com.example.Naruto_DB;

import com.example.Naruto_DB.jutsu.JutsuDTO;
import com.example.Naruto_DB.personagem.PersonagemDTO;
import com.example.Naruto_DB.jutsu.Jutsu;
import com.example.Naruto_DB.personagem.Personagem;
import com.example.Naruto_DB.repository.JutsuRepository;
import com.example.Naruto_DB.repository.PersonagemRepository;
import com.example.Naruto_DB.service.PersonagemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonagemServiceTests {
    @Mock
    private PersonagemRepository personagemRepository;

    @Mock
    private JutsuRepository jutsuRepository;

    @InjectMocks
    private PersonagemService personagemService;


    @Test
    public void testCriarPersonagem() {
        PersonagemDTO personagemDTO = new PersonagemDTO();
        personagemDTO.setNome("Sasuke");
        personagemDTO.setIdade(16);
        personagemDTO.setAldeia("Konoha");
        personagemDTO.setChakra(100);
        personagemDTO.setVida(100);
        personagemDTO.setJutsus(new HashMap<>());

        Personagem personagem = new Personagem("Sasuke", 16, "Konoha", 100);
        when(personagemRepository.save(any(Personagem.class))).thenReturn(personagem);

        PersonagemDTO resultado = personagemService.criarPersonagem(personagemDTO);

        assertEquals("Sasuke", resultado.getNome());
        verify(personagemRepository, times(1)).save(any(Personagem.class));
    }

    @Test
    public void testListarPersonagens() {
        Map<String, JutsuDTO> jutsus = new HashMap<>();
        Personagem personagem1 = new Personagem("Naruto", 16, "Konoha", 100);
        Personagem personagem2 = new Personagem("Sasuke", 16, "Konoha", 100);
        List<Personagem> personagens = Arrays.asList(personagem1, personagem2);

        when(personagemRepository.findAll()).thenReturn(personagens);

        List<PersonagemDTO> resultado = personagemService.listarPersonagens();

        assertEquals(2, resultado.size());
        assertEquals("Naruto", resultado.get(0).getNome());
        assertEquals("Sasuke", resultado.get(1).getNome());
        verify(personagemRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarPersonagemPorId() {
        Map<String, JutsuDTO> jutsus = new HashMap<>();
        Personagem personagem = new Personagem("Naruto", 16, "Konoha", 100);
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        PersonagemDTO resultado = personagemService.buscarPersonagemPorId(1L);

        assertEquals("Naruto", resultado.getNome());
        verify(personagemRepository, times(1)).findById(1L);
    }

    @Test
    public void testAlterarPersonagem() {
        PersonagemDTO novosDados = new PersonagemDTO();
        novosDados.setNome("Naruto Uzumaki");
        novosDados.setIdade(17);
        novosDados.setAldeia("Konoha");
        novosDados.setChakra(100);
        novosDados.setVida(100);
        novosDados.setJutsus(new HashMap<>());

        Personagem personagem = new Personagem("Naruto", 16, "Konoha", 100);
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        personagemService.alterarPersonagem(1L, novosDados);

        assertEquals("Naruto Uzumaki", personagem.getNome());
        assertEquals(17, personagem.getIdade());
        verify(personagemRepository, times(1)).save(personagem);
    }

    @Test
    public void testEliminarPersonagem() {
        Long id = 1L;
        doNothing().when(personagemRepository).deleteById(id);

        personagemService.eliminarPersonagem(id);

        verify(personagemRepository, times(1)).deleteById(id);
    }

    @Test
    public void testCriarJutsu() {
        JutsuDTO jutsuDTO = new JutsuDTO(null, "Rasengan", 30, 10);

        Personagem personagem = new Personagem("Naruto", 16, "Konoha", 100);
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        Jutsu jutsu = new Jutsu("Rasengan", 30, 10);
        when(jutsuRepository.save(any(Jutsu.class))).thenReturn(jutsu);

        JutsuDTO resultado = personagemService.criarJutsu(1L, jutsuDTO);

        assertEquals("Rasengan", resultado.getNome());
        assertEquals(30, resultado.getDano());
        assertEquals(10, resultado.getConsumoDeChakra());
        verify(jutsuRepository, times(1)).save(any(Jutsu.class));
        verify(personagemRepository, times(1)).save(any(Personagem.class));
    }
}
