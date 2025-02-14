package com.example.Naruto_DB_PT_1.service;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import com.example.Naruto_DB_PT_1.jutsu.JutsuDTO;
import com.example.Naruto_DB_PT_1.personagem.Personagem;
import com.example.Naruto_DB_PT_1.personagem.PersonagemDTO;
import com.example.Naruto_DB_PT_1.repository.JutsuRepository;
import com.example.Naruto_DB_PT_1.repository.PersonagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private JutsuRepository jutsuRepository;

    private List<JutsuDTO> converterJutsusParaDTO(List<Jutsu> jutsus) {
        if (jutsus == null) {
            return Collections.emptyList();
        }
        return jutsus.stream()
                .map(jutsu -> new JutsuDTO(
                        jutsu.getId(),
                        jutsu.getNome(),
                        jutsu.getDano(),
                        jutsu.getConsumoDeChakra()
                ))
                .collect(Collectors.toList());
    }

    public PersonagemDTO criarPersonagem(PersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.getNome(), personagemDTO.getIdade(), personagemDTO.getAldeia(), personagemDTO.getChakra(), personagemDTO.getVida());
        Personagem novoPersonagem = personagemRepository.save(personagem);
        List<JutsuDTO> jutsusDTO = novoPersonagem.getJutsus().stream()
                .map(jutsu -> new JutsuDTO(
                        jutsu.getId(),
                        jutsu.getNome(),
                        jutsu.getDano(),
                        jutsu.getConsumoDeChakra()
                ))
                .collect(Collectors.toList());
        return new PersonagemDTO(
                novoPersonagem.getId(),
                novoPersonagem.getNome(),
                novoPersonagem.getIdade(),
                novoPersonagem.getAldeia(),
                novoPersonagem.getChakra(),
                novoPersonagem.getVida(),
                jutsusDTO
        );
    }

    public void alterarPersonagem(Long id, PersonagemDTO novosDados) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        personagem.setNome(novosDados.getNome());
        personagem.setIdade(novosDados.getIdade());
        personagem.setAldeia(novosDados.getAldeia());
        personagem.setVida(novosDados.getVida());
        personagemRepository.save(personagem);
    }

    public void atualizarChakra(Long id, int novoChakra) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        personagem.setChakra(novoChakra);
        personagemRepository.save(personagem);
    }

    public boolean eliminarPersonagem(Long id) {
        Optional<Personagem> personagemOptional = personagemRepository.findById(id);
        if (personagemOptional.isPresent()) {
            personagemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<PersonagemDTO> listarPersonagens() {
        return personagemRepository.findAll().stream()
                .map(p -> new PersonagemDTO(
                        p.getId(),
                        p.getNome(),
                        p.getIdade(),
                        p.getAldeia(),
                        p.getChakra(),
                        p.getVida(),
                        converterJutsusParaDTO(p.getJutsus())
                        )
                ).collect(Collectors.toList());
    }

    public PersonagemDTO buscarPersonagemPorId(Long id) {
        return personagemRepository.findById(id)
                .map(personagem -> new PersonagemDTO(
                        personagem.getId(),
                        personagem.getNome(),
                        personagem.getIdade(),
                        personagem.getAldeia(),
                        personagem.getChakra(),
                        personagem.getVida(),
                        converterJutsusParaDTO(personagem.getJutsus())
                ))
                .orElse(null);
    }

}
