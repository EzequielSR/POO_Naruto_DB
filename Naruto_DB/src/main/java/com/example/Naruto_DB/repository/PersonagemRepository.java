package com.example.Naruto_DB.repository;

import com.example.Naruto_DB.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}