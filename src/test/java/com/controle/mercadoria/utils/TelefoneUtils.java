package com.controle.mercadoria.utils;

import com.controle.mercadoria.dto.request.TelefoneDTO;
import com.controle.mercadoria.enums.TipoDeContato;
import com.controle.mercadoria.model.Telefone;

public class TelefoneUtils {

    private static final Long TELEFONE_ID = 1L;
    private static final String NUMERO_TELEFONE = "73999999999";
    private static final TipoDeContato TIPO_DE_CONTATO = TipoDeContato.CELULAR;


    public static TelefoneDTO criaFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .tipoContato(TIPO_DE_CONTATO)
                .build();
    }
    public static Telefone criaFakeEntity() {
        return Telefone.builder()
                .Id(TELEFONE_ID)
                .numero(NUMERO_TELEFONE)
                .tipoContato(TIPO_DE_CONTATO)
                .build();
    }
}
