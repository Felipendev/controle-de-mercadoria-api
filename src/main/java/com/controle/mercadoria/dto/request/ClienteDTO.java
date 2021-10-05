package com.controle.mercadoria.dto.request;


import com.controle.mercadoria.enums.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;


    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String codigo;

    private LocalDate dataRecebimento;

    private LocalDate dataDeEntrega;

    @Valid
    @NotEmpty
    private String contato;

    private StatusProduto statusProduto = StatusProduto.RECEBIDO;

}
