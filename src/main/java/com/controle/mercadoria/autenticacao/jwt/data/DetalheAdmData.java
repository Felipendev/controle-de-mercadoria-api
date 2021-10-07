package com.controle.mercadoria.autenticacao.jwt.data;

import com.controle.mercadoria.autenticacao.jwt.model.AdmModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheAdmData implements UserDetails {

    private final Optional<AdmModel> adm;

    public DetalheAdmData(Optional<AdmModel> adm) {
        this.adm = adm;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return adm.orElse(new AdmModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return adm.orElse(new AdmModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
