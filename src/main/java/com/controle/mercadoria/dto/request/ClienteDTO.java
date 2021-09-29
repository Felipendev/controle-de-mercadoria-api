package com.controle.mercadoria.dto.request;


import com.controle.mercadoria.enums.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;


    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String codigo;

    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = { "M/d/yy", "dd.MM.yyyy" })
    private LocalDate dataRecebimento;

    private LocalDate dataDeEntrega;

    @Valid
    @NotEmpty
    @Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$", message = "o numero de celular  deve ser valido")
    private String contato;

    @Builder.Default
    private StatusProduto statusProduto = StatusProduto.RECEBIDO;

}
