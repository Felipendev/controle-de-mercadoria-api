package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.mapper.ClienteMapper;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public MessageResponseDTO criaCliente(ClienteDTO clienteDTO) {
        Cliente clienteParaSalvar = clienteMapper.toModel(clienteDTO);

        Cliente clienteSalvo = clienteRepository.save(clienteParaSalvar);
        return MessageResponseDTO
                .builder()
                .mensagem("Cliente criado com o ID " + clienteSalvo.getId())
                .build();
    }
}
