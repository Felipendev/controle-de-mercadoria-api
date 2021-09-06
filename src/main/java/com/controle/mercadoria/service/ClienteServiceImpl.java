package com.controle.mercadoria.service;

import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }

    @Override
    public List<Cliente> listAll(Cliente cliente) {
        List<Cliente> clientes = clienteRepository.listAll(cliente);
        return clientes;
    }

    @Override
    public Cliente buscaClientePorCodigo(String codigo) {
        List<Cliente> codigoCliente = clienteRepository.buscaClientePorCodigo(codigo);
        return (Cliente) codigoCliente;
    }
}
