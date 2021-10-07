package com.controle.mercadoria.autenticacao.jwt.controller;

import com.controle.mercadoria.autenticacao.jwt.model.AdmModel;
import com.controle.mercadoria.autenticacao.jwt.repository.AdmRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/adm")
public class AdmController {
    private final AdmRepository repository;
    private final PasswordEncoder encoder;

    public AdmController(AdmRepository admRepository, PasswordEncoder encoder) {
        this.repository = admRepository;
        this.encoder = encoder;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<AdmModel>> listarTodos() {
        log.info("[Inicia] AdmController - listarTodos");
        ResponseEntity<List<AdmModel>> listResponseEntity = ResponseEntity.ok(repository.findAll());
        log.info("[Finaliza] AdmController - listarTodos");
        return listResponseEntity;
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password){
        log.info("[Inicia] AdmController - validarSenha");
        Optional<AdmModel> optionalAdm = repository.findByLogin(login);
        if(optionalAdm.isEmpty()) {
            ResponseEntity<Boolean> response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
            return response;
        }
        boolean valid = false;
        AdmModel adm = optionalAdm.get();
        valid = encoder.matches(password, adm.getPassword());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        ResponseEntity<Boolean> response = ResponseEntity.status(status).body(valid);
        log.info("[Finaliza] AdmController - validarSenha");
        return response;
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AdmModel> salvar(@RequestBody AdmModel adm) {
        log.info("[Inicia] AdmController - salvar");
        adm.setPassword(encoder.encode(adm.getPassword()));
        ResponseEntity<AdmModel> admSalvo = ResponseEntity.ok(repository.save(adm));
        log.info("[Finaliza] AdmController - salvar");
        return admSalvo;
    }
}
