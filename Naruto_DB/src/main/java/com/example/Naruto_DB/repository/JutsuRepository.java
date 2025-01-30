package com.example.Naruto_DB.repository;

import com.example.Naruto_DB.jutsu.Jutsu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JutsuRepository extends JpaRepository<Jutsu, Long> {
}
