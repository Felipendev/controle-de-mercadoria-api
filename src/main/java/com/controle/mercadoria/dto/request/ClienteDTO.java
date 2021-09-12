package com.controle.mercadoria.dto.request;

import com.controle.mercadoria.enums.StatusProduto;
import com.controle.mercadoria.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
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
    private String codigo;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    private LocalDateTime dataRecebimento;

    private LocalDateTime dataDeEntrega;

    @Valid
    @NotEmpty
    private List<Phone> telefones;

    private StatusProduto statusProduto = StatusProduto.RECEBIDO;
}
