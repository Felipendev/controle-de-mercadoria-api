package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.exception.ClienteNotFoundException;
import com.controle.mercadoria.mapper.ClienteMapper;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class  ClienteService {

    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    public MessageResponseDTO criaCliente(ClienteDTO clienteDTO) {
        log.info("[Inicio] ClienteService - criaCliente");
        Cliente clienteParaSalvar = clienteMapper.toModel(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(clienteParaSalvar);
        log.info("[Finaliza] ClienteService - criaCliente");
        return buildCliente(clienteSalvo.getId(), "Cliente criado com o ID ");
    }

    public List<ClienteDTO> buscaPorTodos() {
        log.info("[Inicio] ClienteService - buscaPorTodos");
        List<Cliente> todosClientes = clienteRepository.findAll();
        List<ClienteDTO> collect = todosClientes.stream().map(clienteMapper::toDTO)
                .collect(Collectors.toList());
        log.info("[Finaliza] ClienteService - buscaPorTodos");
        return collect;
    }

    public ClienteDTO buscaPorId(Long id) throws ClienteNotFoundException {
        log.info("[Inicio] ClienteService - buscaPorId");
        Cliente cliente = verificaSeExiste(id);
        log.info("[Finaliza] ClienteService - buscaPorId");
        return clienteMapper.toDTO(cliente);
    }


    public void delete(Long id) throws ClienteNotFoundException {
        log.info("[Inicio] ClienteService - delete");
        verificaSeExiste(id);
        clienteRepository.deleteById(id);
        log.info("[Finaliza] ClienteService - delete");
    }

    public MessageResponseDTO atualizaPorId(Long id, ClienteDTO clienteDTO) throws ClienteNotFoundException {
        log.info("[Inicio] ClienteService - atualizaPorId");
        verificaSeExiste(id);
        Cliente clienteParaAtualizar = clienteMapper.toModel(clienteDTO);
        Cliente clienteAtualizado = clienteRepository.save(clienteParaAtualizar);
        MessageResponseDTO mensagemClienteCriadoComSucesso = buildCliente(clienteAtualizado.getId(), "Cliente atualizado com o ID ");
        log.info("[Finaliza] ClienteService - atualizaPorId");
        return mensagemClienteCriadoComSucesso;
    }

    private Cliente verificaSeExiste(Long id) throws ClienteNotFoundException {
        log.info("[Inicio] ClienteService - verificaSeExiste");
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
        log.info("[Finaliza] ClienteService - verificaSeExiste");
        return cliente;
    }

    private MessageResponseDTO buildCliente(Long id, String mensagem) {
        log.info("[Inicio] ClienteService - buildCliente");
        MessageResponseDTO build = MessageResponseDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
        log.info("[Finaliza] ClienteService - buildCliente");
        return build;
    }
}
