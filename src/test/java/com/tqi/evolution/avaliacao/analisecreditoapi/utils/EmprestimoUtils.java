package com.tqi.evolution.avaliacao.analisecreditoapi.utils;

import com.tqi.evolution.avaliacao.analisecreditoapi.dto.request.ClienteDTO;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Emprestimo;

import java.math.BigDecimal;

public class EmprestimoUtils {
    private static final Long codigo = 2L;
    private static final BigDecimal valor = BigDecimal.valueOf(500);
    private static final String dataPrimeiraParcela = "22/02/2022";
    private static final Long quantidade = 27L;

    public static Emprestimo createFakeEntity(){
        return Emprestimo.builder().codigo(codigo)
                .valor(valor)
                .dataPrimeiraParcela(dataPrimeiraParcela)
                .quantidade(quantidade)
                .cliente(ClienteUtils.createFakeEntity()).build();
    }
}
