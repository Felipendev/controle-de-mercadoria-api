package com.controle.mercadoria.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDeContato {

    CASA("Casa"),
    CELULAR("Celular"),
    Comercial("Comercial");

    private final String descricao;

}
