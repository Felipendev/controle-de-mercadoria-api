package com.controle.mercadoria.repository;

import com.controle.mercadoria.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository {

    List<Produto> produtosEntreges(Produto produto);
}
