package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.jutsu.JutsuDTO;
import com.example.Naruto_DB.service.JutsuService;
import com.example.Naruto_DB.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jutsus")
public class JutsuController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private JutsuService jutsuService;

    @Operation(summary = "Criar Jutsu", description = "Cria um jutsu e víncula a um Personagem")
    @PostMapping("/{personagemId}")
    public ResponseEntity<JutsuDTO> criarJutsu(@PathVariable Long personagemId, @RequestBody JutsuDTO jutsuDTO) {
        JutsuDTO novoJutsu = jutsuService.criarJutsu(personagemId, jutsuDTO);
        return ResponseEntity.ok(novoJutsu);
    }

    @Operation(summary = "Buscar Jutsu pelo ID", description = "Busca o Jutsu pelo ID já inserido no sistema")
    @GetMapping("/{personagemId}")
    public ResponseEntity<List<JutsuDTO>> buscarJutsu(@PathVariable Long personagemId) {
        List<JutsuDTO> jutsu = jutsuService.buscarJutsu(personagemId);
        return jutsu != null ? ResponseEntity.ok(jutsu) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Listar todos os Jutsus", description = "Lista em uma array todos os Jutsus presentes no sistema")
    @GetMapping
    public ResponseEntity<List<JutsuDTO>> listarJutsus() {
        List<JutsuDTO> jutsus = jutsuService.listarJutsus();
        return ResponseEntity.ok(jutsus);
    }

    @Operation(summary = "Editar Jutsu", description = "Editar dados do Jutsu já criados no sistema")
    @PutMapping("/{jutsuId}")
    public ResponseEntity<JutsuDTO> editarJutsu(@PathVariable Long jutsuId, @RequestBody JutsuDTO novosDados) {
        jutsuService.alterarJutsu(jutsuId, novosDados);
        return ResponseEntity.ok(novosDados);
    }

    @Operation(summary = "Deletar Jutsu", description = "Deleta Jutsu do sistema vinculado")
    @DeleteMapping("/{jutsuId}")
    public ResponseEntity<String> deletarJutsu(@PathVariable Long jutsuId) {

        if (jutsuService.deletarJutsu(jutsuId)) {
            return ResponseEntity.ok("Jutsu com ID " + jutsuId + " foi excluído com sucesso!");
        }
        return ResponseEntity.status(404).body("Jutsu com ID " + jutsuId + " não encontrado.");
    }

}
