package com.example.Naruto_DB_PT_2.repository;

import com.example.Naruto_DB_PT_2.jutsu.Jutsu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JutsuRepository extends JpaRepository<Jutsu, Long> {
}
