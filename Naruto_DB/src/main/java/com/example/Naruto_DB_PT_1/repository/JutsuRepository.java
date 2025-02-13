package com.example.Naruto_DB_PT_1.repository;

import com.example.Naruto_DB_PT_1.jutsu.Jutsu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JutsuRepository extends JpaRepository<Jutsu, Long> {
}
