package com.controle.mercadoria.service;

import com.controle.mercadoria.dto.request.ClienteDTO;
import com.controle.mercadoria.dto.response.MessageResponseDTO;
import com.controle.mercadoria.model.Cliente;
import com.controle.mercadoria.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.controle.mercadoria.utils.ClienteUtils.criaFakeDTO;
import static com.controle.mercadoria.utils.ClienteUtils.criaFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void testDadoDTOEntaoRetornaMensagem() {
        ClienteDTO clienteDTO = criaFakeDTO();
        Cliente clienteSalvoEsperado = criaFakeEntity();

        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteSalvoEsperado);

        MessageResponseDTO mensagemDeSucessoEsperada = criaRespostaDeMensagemEsperada(clienteSalvoEsperado.getId());
        MessageResponseDTO mensagemDeSucesso = clienteService.criaCliente(clienteDTO);

        assertEquals(mensagemDeSucessoEsperada, mensagemDeSucesso);
    }

    private MessageResponseDTO criaRespostaDeMensagemEsperada(Long id) {
        return MessageResponseDTO
                .builder()
                .mensagem("Cliente criado com o ID " + id)
                .build();
    }
}
