package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.dto.JutsuDTO;
import com.example.Naruto_DB.dto.PersonagemDTO;
import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.service.NarutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private NarutoService narutoService;

    @PostMapping
    public ResponseEntity<PersonagemDTO> adicionarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        PersonagemDTO novoPersonagem = narutoService.criarPersonagem(personagemDTO);
        return ResponseEntity.ok(novoPersonagem);
    }

    @PostMapping("/{personagemId}/jutsus")
    public ResponseEntity<JutsuDTO> criarJutsu(@PathVariable Long personagemId, @RequestBody JutsuDTO jutsuDTO) {
        JutsuDTO novoJutsu = narutoService.criarJutsu(personagemId, jutsuDTO);
        return ResponseEntity.ok(novoJutsu);
    }


    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listarPersonagens() {
        List<PersonagemDTO> personagens = narutoService.listarPersonagens();
        return ResponseEntity.ok(personagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPersonagemPorId(@PathVariable Long id) {
        PersonagemDTO personagem = narutoService.buscarPersonagemPorId(id);
        return personagem != null ? ResponseEntity.ok(personagem) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> alterarPersonagem(@PathVariable Long id, @RequestBody PersonagemDTO novosDados) {
        narutoService.alterarPersonagem(id, novosDados);
        return ResponseEntity.ok(novosDados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonagem(@PathVariable Long id) {
        narutoService.eliminarPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{personagemId}/jutsus/{nomeJutsu}")
    public ResponseEntity<Void> deletarJutsu(@PathVariable Long personagemId, @PathVariable String nomeJutsu) {
        narutoService.deletarJutsu(personagemId, nomeJutsu);
        return ResponseEntity.noContent().build();
    }
}
