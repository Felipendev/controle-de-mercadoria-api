package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.exception.ClienteNotFoundException;
import com.controle.mercadoria.mapper.ClienteMapper;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ClienteDTO> listAll() {
        List<Cliente> todosClientes = clienteRepository.findAll();
        return todosClientes.stream().map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscaPorId(Long id) throws ClienteNotFoundException {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
        return clienteMapper.toDTO(cliente);
    }
}
