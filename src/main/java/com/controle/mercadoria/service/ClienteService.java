package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.exception.ClienteNotFoundException;
import com.controle.mercadoria.mapper.ClienteMapper;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    public MessageResponseDTO criaCliente(ClienteDTO clienteDTO) {
        Cliente clienteParaSalvar = clienteMapper.toModel(clienteDTO);

        Cliente clienteSalvo = clienteRepository.save(clienteParaSalvar);
        return buildCliente(clienteSalvo.getId(), "Cliente criado com o ID ");
    }

    public List<ClienteDTO> buscaPorTodos() {
        List<Cliente> todosClientes = clienteRepository.findAll();
        return todosClientes.stream().map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscaPorId(Long id) throws ClienteNotFoundException {
        Cliente cliente = verificaSeExiste(id);
        return clienteMapper.toDTO(cliente);
    }


    public void delete(Long id) throws ClienteNotFoundException {
        verificaSeExiste(id);
        clienteRepository.deleteById(id);

    }

    public MessageResponseDTO atualizaPorId(Long id, ClienteDTO clienteDTO) throws ClienteNotFoundException {
        verificaSeExiste(id);
        Cliente clienteParaAtualizar = clienteMapper.toModel(clienteDTO);
        Cliente clienteAtualizado = clienteRepository.save(clienteParaAtualizar);
        return buildCliente(clienteAtualizado.getId(), "Cliente atualizado com o ID ");
    }

    private Cliente verificaSeExiste(Long id) throws ClienteNotFoundException {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
    }

    private MessageResponseDTO buildCliente(Long id, String mensagem) {
        return MessageResponseDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }
}
