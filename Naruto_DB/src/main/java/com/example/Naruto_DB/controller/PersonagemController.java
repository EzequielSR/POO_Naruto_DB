package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.repository.PersonagemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;


    @Operation(summary = "List all personagens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    @GetMapping
    public List<Personagem> getAllPersonagens() {
        return personagemRepository.findAll();
    }

    @Operation(summary = "Create a new personagem")
    @PostMapping
    public Personagem createPersonagem(@RequestBody Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    @Operation(summary = "Get a personagem by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Personagem> getPersonagemById(@PathVariable Long id) {
        return personagemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
