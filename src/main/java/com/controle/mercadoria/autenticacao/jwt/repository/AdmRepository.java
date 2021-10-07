package com.controle.mercadoria.autenticacao.jwt.repository;

import com.controle.mercadoria.autenticacao.jwt.model.AdmModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmRepository extends JpaRepository<AdmModel, Integer> {

        public Optional<AdmModel> findByLogin(String login);
}
