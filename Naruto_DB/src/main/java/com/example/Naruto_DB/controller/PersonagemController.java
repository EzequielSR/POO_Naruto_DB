package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.jutsu.JutsuDTO;
import com.example.Naruto_DB.personagem.PersonagemDTO;
import com.example.Naruto_DB.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<PersonagemDTO> adicionarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        PersonagemDTO novoPersonagem = personagemService.criarPersonagem(personagemDTO);
        return ResponseEntity.ok(novoPersonagem);
    }

    @PostMapping("/{personagemId}/jutsus")
    public ResponseEntity<JutsuDTO> criarJutsu(@PathVariable Long personagemId, @RequestBody JutsuDTO jutsuDTO) {
        JutsuDTO novoJutsu = personagemService.criarJutsu(personagemId, jutsuDTO);
        return ResponseEntity.ok(novoJutsu);
    }


    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listarPersonagens() {
        List<PersonagemDTO> personagens = personagemService.listarPersonagens();
        return ResponseEntity.ok(personagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPersonagemPorId(@PathVariable Long id) {
        PersonagemDTO personagem = personagemService.buscarPersonagemPorId(id);
        return personagem != null ? ResponseEntity.ok(personagem) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> alterarPersonagem(@PathVariable Long id, @RequestBody PersonagemDTO novosDados) {
        personagemService.alterarPersonagem(id, novosDados);
        return ResponseEntity.ok(novosDados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersonagem(@PathVariable Long id) {
        if( personagemService.eliminarPersonagem(id)){
            return ResponseEntity.ok("Personagem com ID " + id + " foi excluído com sucesso!");
        };
        return ResponseEntity.status(404).body("Personagem com ID " + id + " não encontrado.");
    }

    @DeleteMapping("/{personagemId}/jutsus/{nomeJutsu}")
    public ResponseEntity<Void> deletarJutsu(@PathVariable Long personagemId, @PathVariable String nomeJutsu) {
        personagemService.deletarJutsu(personagemId, nomeJutsu);
        return ResponseEntity.noContent().build();
    }
}
