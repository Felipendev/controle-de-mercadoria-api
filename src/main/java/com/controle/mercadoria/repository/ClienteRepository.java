package com.controle.mercadoria.repository;

import com.controle.mercadoria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente save(Cliente cliente);
    List<Cliente> listAll(Cliente clientes);
    List<Cliente> buscaClientePorCodigo(String codigo);
}
