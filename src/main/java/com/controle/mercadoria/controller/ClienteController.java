package com.controle.mercadoria.controller;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.exception.ClienteNotFoundException;
import com.controle.mercadoria.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {
    private ClienteService clienteService;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        log.info("[Inicia] ClienteController - criaCliente");
        MessageResponseDTO messageResponseDTO = clienteService.criaCliente(clienteDTO);
        log.info("[Finaliza] ClienteController - criaCliente");
        return messageResponseDTO;
    }

    @CrossOrigin
    @GetMapping(value = "/listAll")
    public List<ClienteDTO> buscaTodos() {
        log.info("[Inicia] ClienteController - buscaTodos");
        List<ClienteDTO> clienteDTOS = clienteService.buscaPorTodos();
        log.info("[Finaliza] ClienteController - buscaTodos");
        return clienteDTOS;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ClienteDTO buscaPorId(@PathVariable Long id) throws ClienteNotFoundException {
        log.info("[Inicia] ClienteController - buscaPorId");
        ClienteDTO clienteDTO = clienteService.buscaPorId(id);
        log.info("[Finaliza] ClienteController - buscaPorId");
        return clienteDTO;
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public MessageResponseDTO atualizaPorId(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) throws ClienteNotFoundException {
        log.info("[Inicia] ClienteController - atualizaPorId");
        MessageResponseDTO messageResponseDTO = clienteService.atualizaPorId(id, clienteDTO);
        log.info("[Finaliza] ClienteController - atualizaPorId");
        return messageResponseDTO;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCliente(@PathVariable Long id) throws ClienteNotFoundException {
        log.info("[Inicia] ClienteController - deletaCliente");
        clienteService.delete(id);
        log.info("[Finaliza] ClienteController - deletaCliente");
    }
}
