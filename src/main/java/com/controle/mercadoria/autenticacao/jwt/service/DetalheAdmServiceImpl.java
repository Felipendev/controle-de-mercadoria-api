package com.controle.mercadoria.autenticacao.jwt.service;

import com.controle.mercadoria.autenticacao.jwt.data.DetalheAdmData;
import com.controle.mercadoria.autenticacao.jwt.model.AdmModel;
import com.controle.mercadoria.autenticacao.jwt.repository.AdmRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class DetalheAdmServiceImpl implements UserDetailsService {

    private final AdmRepository repository;

    public DetalheAdmServiceImpl(AdmRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AdmModel> adm = repository.findByLogin(username);
        if(adm.isEmpty()) {
            throw new UsernameNotFoundException("Administrador [" + username + "] não encontrado");
        }

        return new DetalheAdmData(adm);
    }
}
