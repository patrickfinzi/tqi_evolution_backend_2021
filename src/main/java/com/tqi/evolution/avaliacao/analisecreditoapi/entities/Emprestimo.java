package com.tqi.evolution.avaliacao.analisecreditoapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String dataPrimeiraParcela;

    @Column(nullable = false)
    private Long quantidade;

    @ManyToOne
    private Cliente cliente;

}
