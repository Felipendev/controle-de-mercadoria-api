package com.controle.mercadoria.model;

import com.controle.mercadoria.enums.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String sobrenome;


    @Column(nullable = false)
    private LocalDate dataRecebimento;

    private LocalDate dataDeEntrega;

    @Column(nullable = false)
    private String contato;

    @Builder.Default
    private StatusProduto statusProduto = StatusProduto.RECEBIDO;
}
