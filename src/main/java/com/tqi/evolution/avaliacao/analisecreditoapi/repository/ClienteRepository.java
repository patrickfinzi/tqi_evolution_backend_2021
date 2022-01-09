package com.tqi.evolution.avaliacao.analisecreditoapi.repository;

import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("select c from Cliente c where c.email = ?1 and c.senha = ?2")
    Cliente loginCliente(String email, String senha);
}
