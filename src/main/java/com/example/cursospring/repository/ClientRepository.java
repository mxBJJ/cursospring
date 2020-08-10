package com.example.cursospring.repository;

import com.example.cursospring.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional(readOnly = true)
    Client findByEmail(String email);
}
