package com.example.Naruto_DB_PT_1.repository;

import com.example.Naruto_DB_PT_1.personagem.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}

