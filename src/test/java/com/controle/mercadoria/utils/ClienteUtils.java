package com.controle.mercadoria.utils;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.enums.StatusProduto;
import com.controle.mercadoria.model.Cliente;

import java.time.LocalDate;

public class ClienteUtils {
    private static final Long CLIENTE_ID = 1L;
    private static final String NOME = "Felipe";
    private static final String SOBRENOME = "Felipe";
    private static final String CODIGO = "0001";
    private static final String CONTATO = "73981230810";
    private static final LocalDate DATA_RECEBIMENTO = LocalDate.of(2021,10,04) ;
    private static final StatusProduto STATUS_PRODUTO = StatusProduto.RECEBIDO;

    public static ClienteDTO criaFakeDTO() {
        return ClienteDTO.builder()
                .codigo(CODIGO)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .dataRecebimento(DATA_RECEBIMENTO)
                .statusProduto(STATUS_PRODUTO)
                .contato(CONTATO)
                .build();
    }

    public static Cliente criaFakeEntity() {
        return Cliente.builder()
                .id(CLIENTE_ID)
                .codigo(CODIGO)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .dataRecebimento(DATA_RECEBIMENTO)
                .contato(CONTATO)
                .statusProduto(STATUS_PRODUTO)
                .build();
    }

}
