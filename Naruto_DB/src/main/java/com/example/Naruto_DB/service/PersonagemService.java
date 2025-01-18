package com.example.Naruto_DB.service;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> listarPersonagens(){
        return personagemRepository.findAll();
    }

    public void salvarPersonagem(Personagem personagem){
        personagemRepository.save(personagem);
    }
}
