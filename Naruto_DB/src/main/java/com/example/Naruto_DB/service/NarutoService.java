package com.example.Naruto_DB.service;

import com.example.Naruto_DB.dto.JutsuDTO;
import com.example.Naruto_DB.dto.PersonagemDTO;
import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.repository.JutsuRepository;
import com.example.Naruto_DB.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NarutoService {
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private JutsuRepository jutsuRepository;

    public PersonagemDTO criarPersonagem(PersonagemDTO personagemDTO) {
        Personagem personagem = new Personagem(personagemDTO.getNome(), personagemDTO.getIdade(), personagemDTO.getAldeia(), personagemDTO.getVida());
        Personagem novoPersonagem = personagemRepository.save(personagem);
        return new PersonagemDTO(novoPersonagem.getId(), novoPersonagem.getNome(), novoPersonagem.getIdade(), novoPersonagem.getAldeia(), novoPersonagem.getChakra(), novoPersonagem.getVida(), novoPersonagem.getJutsus().values().stream()
                .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                .collect(Collectors.toMap(JutsuDTO::getNome, jutsuDTO -> jutsuDTO))); }

    public JutsuDTO criarJutsu(Long personagemId, JutsuDTO jutsuDTO) {
        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Jutsu jutsu = new Jutsu(jutsuDTO.getNome(), jutsuDTO.getDano(), jutsuDTO.getConsumoDeChakra());

        personagem.adicionarNovoJutsu(jutsu.getNome(), jutsu);

        jutsuRepository.save(jutsu);

        personagemRepository.save(personagem);

        return new JutsuDTO(jutsuDTO.getId(), jutsuDTO.getNome(), jutsuDTO.getDano(), jutsuDTO.getConsumoDeChakra());
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

    public void eliminarPersonagem(Long id) {
        personagemRepository.deleteById(id);
    }

    public void deletarJutsu(Long personagemId, String nomeJutsu) {
        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        personagem.getJutsus().remove(nomeJutsu);
        personagemRepository.save(personagem);
    }

    public List<PersonagemDTO> listarPersonagens() {
        return personagemRepository.findAll().stream()
                .map(p -> {
                    Map<String, JutsuDTO> jutsuDTOs = p.getJutsus().values().stream()
                            .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                            .collect(Collectors.toMap(JutsuDTO::getNome, jutsuDTO -> jutsuDTO));

                    return new PersonagemDTO(p.getId(), p.getNome(), p.getIdade(), p.getAldeia(), p.getChakra(), p.getVida(), jutsuDTOs);
                })
                .collect(Collectors.toList());
    }

    public PersonagemDTO buscarPersonagemPorId(Long id) {
        Personagem personagem = personagemRepository.findById(id).orElse(null);
        if (personagem != null) {
            Map<String, JutsuDTO> jutsuDTOs = personagem.getJutsus().values().stream()
                    .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                    .collect(Collectors.toMap(JutsuDTO::getNome, jutsuDTO -> jutsuDTO));

            return new PersonagemDTO(personagem.getId(), personagem.getNome(), personagem.getIdade(), personagem.getAldeia(), personagem.getChakra(), personagem.getVida(), jutsuDTOs);
        }
        return null;
    }

}
