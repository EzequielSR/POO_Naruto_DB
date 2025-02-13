package com.example.Naruto_DB_PT_2.service;

import com.example.Naruto_DB_PT_2.jutsu.JutsuDTO;
import com.example.Naruto_DB_PT_2.personagem.Personagem;
import com.example.Naruto_DB_PT_2.personagem.PersonagemDTO;
import com.example.Naruto_DB_PT_2.repository.JutsuRepository;
import com.example.Naruto_DB_PT_2.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private JutsuRepository jutsuRepository;

    public PersonagemDTO criarPersonagem(PersonagemDTO personagemDTO) {
        Personagem personagem = new Personagem(personagemDTO.getNome(), personagemDTO.getIdade(), personagemDTO.getAldeia(), personagemDTO.getVida());
        Personagem novoPersonagem = personagemRepository.save(personagem);
        return new PersonagemDTO(novoPersonagem.getId(), novoPersonagem.getNome(), novoPersonagem.getIdade(), novoPersonagem.getAldeia(), novoPersonagem.getChakra(), novoPersonagem.getVida(), novoPersonagem.getJutsus().values().stream()
                .map(jutsu -> new JutsuDTO(jutsu.getId(), jutsu.getNome(), jutsu.getDano(), jutsu.getConsumoDeChakra()))
                .collect(Collectors.toMap(JutsuDTO::getNome, jutsuDTO -> jutsuDTO)));
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
