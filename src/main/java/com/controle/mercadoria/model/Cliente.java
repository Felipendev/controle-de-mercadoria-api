package com.controle.mercadoria.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @NotEmpty(message = "o nome não pode estar vazio")
    private String nome;

    private String contato;
    private LocalDateTime dataRecebimento;
    private LocalDateTime dataDeEntrega;

    @Builder.Default
    private StatusProduto statusProduto = StatusProduto.RECEBIDO;}
