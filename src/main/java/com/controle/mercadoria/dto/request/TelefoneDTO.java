package com.controle.mercadoria.dto.request;

import com.controle.mercadoria.enums.TipoDeContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long Id;

    @Enumerated(EnumType.STRING)
    private TipoDeContato tipoContato;

    @NotEmpty
    @Size(min = 10, max = 14)
    private String numero;
}
