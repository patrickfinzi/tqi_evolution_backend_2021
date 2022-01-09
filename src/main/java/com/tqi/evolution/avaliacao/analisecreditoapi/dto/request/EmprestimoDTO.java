package com.tqi.evolution.avaliacao.analisecreditoapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmprestimoDTO {
    private Long codigo;
    private BigDecimal valor;
    private String dataPrimeiraParcela;
    private Long quantidade;
    private ClienteDTO clienteDTO;
}
