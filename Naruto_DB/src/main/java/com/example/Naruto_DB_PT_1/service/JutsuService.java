package com.example.Naruto_DB_PT_1.service;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import com.example.Naruto_DB_PT_1.jutsu.JutsuDTO;
import com.example.Naruto_DB_PT_1.personagem.Personagem;
import com.example.Naruto_DB_PT_1.repository.JutsuRepository;
import com.example.Naruto_DB_PT_1.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JutsuService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private JutsuRepository jutsuRepository;


    public JutsuDTO criarJutsu(Long personagemId, JutsuDTO jutsuDTO) {
        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Jutsu jutsu = new Jutsu(jutsuDTO.getNome(), jutsuDTO.getDano(), jutsuDTO.getConsumoDeChakra());

        personagem.adicionarNovoJutsu(jutsu); // Agora adiciona diretamente à lista

        jutsuRepository.save(jutsu);

        personagemRepository.save(personagem);

        return new JutsuDTO(jutsuDTO.getId(), jutsuDTO.getNome(), jutsuDTO.getDano(), jutsuDTO.getConsumoDeChakra());
    }

    public List<JutsuDTO> buscarJutsu(Long personagemId) {
        Personagem personagem = personagemRepository.findById(personagemId).orElse(null);

        return personagem.getJutsus().stream()
                .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                .collect(Collectors.toList());
    }

    public List<JutsuDTO> listarJutsus() {
        return personagemRepository.findAll().stream()
                .flatMap(personagem -> personagem.getJutsus().stream())
                .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                .collect(Collectors.toList());
    }

    public void alterarJutsu(Long jutsuId, JutsuDTO novosDados) {
        Jutsu jutsu = jutsuRepository.findById(jutsuId)
                .orElseThrow(() -> new RuntimeException("Jutsu não encontrado"));

        jutsu.setNome(novosDados.getNome());
        jutsu.setDano(novosDados.getDano());
        jutsu.setConsumoDeChakra(novosDados.getConsumoDeChakra());

        jutsuRepository.save(jutsu);
    }

    public boolean deletarJutsu(Long jutsuId) {
        Optional<Jutsu> jutsuOptional = jutsuRepository.findById(jutsuId);
        if (jutsuOptional.isPresent()) {
            jutsuRepository.deleteById(jutsuId);
            return true;
        }
        return false;
    }
}
