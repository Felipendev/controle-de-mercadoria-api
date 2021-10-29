package com.controle.mercadoria.dto.request;


import com.controle.mercadoria.enums.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;


    @Size(min = 2, max = 100)
    private String nome;



    @Size(min = 2, max = 100)
    private String sobrenome;


    @Size(min = 2, max = 100)
    private String codigo;

    private LocalDate dataRecebimento;

    private LocalDate dataDeEntrega;

    @Valid
    @Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$", message = "o numero de celular deve ser valido")
    private String contato;

    @Builder.Default
    private StatusProduto statusProduto = StatusProduto.RECEBIDO;

}
