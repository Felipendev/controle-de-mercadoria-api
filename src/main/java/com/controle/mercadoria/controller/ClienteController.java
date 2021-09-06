package com.controle.mercadoria.controller;

import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class ClienteController {
    private ClienteRepository clienteRepository;


    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") String codigo) {
        return clienteRepository.buscaClientePorCodigo(codigo).stream()
                .map(record -> ResponseEntity.ok().body(record)).findAny().orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "api/usuario/salvar")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }


}
