package com.controle.mercadoria.controller;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.exception.ClienteNotFoundException;
import com.controle.mercadoria.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.criaCliente(clienteDTO);
    }

    @GetMapping(value = "/listAll")
    public List<ClienteDTO> buscaTodos() {
       return clienteService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ClienteDTO buscaPorId(@PathVariable Long id) throws ClienteNotFoundException {
        return clienteService.buscaPorId(id);
    }
}
