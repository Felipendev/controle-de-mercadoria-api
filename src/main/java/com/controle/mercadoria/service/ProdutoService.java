package com.controle.mercadoria.service;

import com.controle.mercadoria.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscaProdutoPorStatus();
}
