package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public MessageResponseDTO criaCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return MessageResponseDTO
                .builder()
                .mensagem("Cliente criado com o ID " + clienteSalvo.getId())
                .build();
    }
}
