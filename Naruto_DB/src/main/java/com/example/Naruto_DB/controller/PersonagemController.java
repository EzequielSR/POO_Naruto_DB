package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public List<Personagem> listar(){
        return personagemService.listarPersonagens();
    }

    @PostMapping
    public void adicionar(@RequestBody Personagem personagem){
        personagemService.salvarPersonagem(personagem);
    }
}
