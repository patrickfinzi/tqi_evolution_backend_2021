package com.tqi.evolution.avaliacao.analisecreditoapi.utils;

import com.tqi.evolution.avaliacao.analisecreditoapi.dto.request.ClienteDTO;
import com.tqi.evolution.avaliacao.analisecreditoapi.entities.Cliente;

import java.math.BigDecimal;

public class ClienteUtils {

    private static final Long id = 1L;
    private static final String cpf = "12345";
    private static final String nome = "patrick";
    private static final String email = "patrick@gmail.com";
    private static final String rg = "mg123";
    private static final String endereco = "casaruacidade";
    private static final BigDecimal renda = BigDecimal.valueOf(10);
    private static final String senha = "123";
    private static final int usuarioLogadoFlag = 0;

    public static Cliente createFakeEntity(){
        return Cliente.builder().id(id)
                .cpf(cpf)
                .nome(nome)
                .email(email)
                .rg(rg)
                .endereco(endereco)
                .renda(renda)
                .senha(senha)
                .usuarioLogadoFlag(usuarioLogadoFlag).build();
    }

    public static ClienteDTO createFakeDTO(){
        return ClienteDTO.builder().id(id)
                .cpf(cpf)
                .nome(nome)
                .email(email)
                .rg(rg)
                .endereco(endereco)
                .renda(renda)
                .senha(senha)
                .usuarioLogadoFlag(1).build();
    }
}
