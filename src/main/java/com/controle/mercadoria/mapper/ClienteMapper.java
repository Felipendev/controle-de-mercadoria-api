package com.controle.mercadoria.mapper;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "dataRecebimento", source = "dataRecebimento", dateFormat = "dd-MM-yyyy")
    Cliente toModel(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);

}
