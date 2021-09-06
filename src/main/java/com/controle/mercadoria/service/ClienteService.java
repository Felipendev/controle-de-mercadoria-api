package com.controle.mercadoria.service;

import com.controle.mercadoria.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> listAll(Cliente cliente);
    Cliente buscaClientePorCodigo (String codigo);

}
