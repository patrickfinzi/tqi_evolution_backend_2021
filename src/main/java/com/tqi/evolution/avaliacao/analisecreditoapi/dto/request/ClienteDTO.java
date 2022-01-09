package com.tqi.evolution.avaliacao.analisecreditoapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String rg;
    private String endereco;
    private BigDecimal renda;
    private String senha;
    private int usuarioLogadoFlag;
}
