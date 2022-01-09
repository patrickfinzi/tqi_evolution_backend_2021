package com.tqi.evolution.avaliacao.analisecreditoapi.repository;

import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("select e from Emprestimo e where e.cliente.id = ?1")
    List<Emprestimo> findByClienteId(Long clienteId);
}
