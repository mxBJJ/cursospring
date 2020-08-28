package com.example.cursospring.repository;

import com.example.cursospring.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
