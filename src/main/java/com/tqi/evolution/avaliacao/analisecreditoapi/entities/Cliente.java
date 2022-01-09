package com.tqi.evolution.avaliacao.analisecreditoapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String cpf;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    String endereco;

    @Column(nullable = false)
    BigDecimal renda;

    @Column(nullable = false)
    String senha;

    int usuarioLogadoFlag;
}
