package com.example.api.repository;

import com.example.api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Métodos adicionais podem ser adicionados conforme necessário
}