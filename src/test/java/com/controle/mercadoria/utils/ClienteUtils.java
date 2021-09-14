package com.controle.mercadoria.utils;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.enums.StatusProduto;
import com.controle.mercadoria.model.Cliente;

import java.time.LocalDateTime;
import java.util.Collections;

public class ClienteUtils {
    private static final Long CLIENTE_ID = 1L;
    private static final String NOME = "Felipe";
    private static final String SOBRENOME = "Felipe";
    private static final String CODIGO = "0001";
    private static final LocalDateTime DATA_RECEBIMENTO = LocalDateTime.of(2021,9,14, 9,12) ;
    private static final StatusProduto STATUS_PRODUTO = StatusProduto.RECEBIDO;

    public static ClienteDTO criaFakeDTO() {
        return ClienteDTO.builder()
                .codigo(CODIGO)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .dataRecebimento(DATA_RECEBIMENTO)
                .statusProduto(STATUS_PRODUTO)
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeDTO()))
                .build();
    }

    public static Cliente criaFakeEntity() {
        return Cliente.builder()
                .id(CLIENTE_ID)
                .codigo(CODIGO)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .dataRecebimento(DATA_RECEBIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeEntity()))
                .statusProduto(STATUS_PRODUTO)
                .build();
    }

}
