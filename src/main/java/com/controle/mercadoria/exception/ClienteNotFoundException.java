package com.controle.mercadoria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception{
    public ClienteNotFoundException(Long id){ super("Cliente não encontrado com o ID " + id);};

}
