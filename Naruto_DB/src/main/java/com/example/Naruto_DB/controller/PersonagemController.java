package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.personagem.PersonagemDTO;
import com.example.Naruto_DB.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Operation(summary = "Criar Personagem", description = "Cria um Persoangem no sistema ")
    @PostMapping
    public ResponseEntity<PersonagemDTO> adicionarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        PersonagemDTO novoPersonagem = personagemService.criarPersonagem(personagemDTO);
        return ResponseEntity.ok(novoPersonagem);
    }

    @Operation(summary = "Listar todos os Personagens", description = "Lista em uma array todos os Personagens presentes no sistema")
    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listarPersonagens() {
        List<PersonagemDTO> personagens = personagemService.listarPersonagens();
        return ResponseEntity.ok(personagens);
    }

    @Operation(summary = "Buscar Personagem pelo ID", description = "Busca o Personagem pelo ID já inserido no sistema")
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPersonagemPorId(@PathVariable Long id) {
        PersonagemDTO personagem = personagemService.buscarPersonagemPorId(id);
        return personagem != null ? ResponseEntity.ok(personagem) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Editar Personagem", description = "Editar dados do Personagem já criados no sistema")
    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> alterarPersonagem(@PathVariable Long id, @RequestBody PersonagemDTO novosDados) {
        personagemService.alterarPersonagem(id, novosDados);
        return ResponseEntity.ok(novosDados);
    }

    @Operation(summary = "Deletar Personagem pelo ID", description = "Exclui Personagem do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersonagem(@PathVariable Long id) {
        if (personagemService.eliminarPersonagem(id)) {
            return ResponseEntity.ok("Personagem com ID " + id + " foi excluído com sucesso!");
        }
        return ResponseEntity.status(404).body("Personagem com ID " + id + " não encontrado.");
    }
}
