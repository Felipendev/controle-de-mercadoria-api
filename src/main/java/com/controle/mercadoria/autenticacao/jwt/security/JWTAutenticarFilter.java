package com.controle.mercadoria.autenticacao.jwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.controle.mercadoria.autenticacao.jwt.data.DetalheAdmData;
import com.controle.mercadoria.autenticacao.jwt.model.AdmModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "758dc434-d587-4372-bc07-3b9b0dcf22fe";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            AdmModel adm = new ObjectMapper()
                    .readValue(request.getInputStream(), AdmModel.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    adm.getLogin(),
                    adm.getPassword(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar o administrador", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        DetalheAdmData admData = (DetalheAdmData) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(admData.getUsername())
                .withExpiresAt(new Date((System.currentTimeMillis() + TOKEN_EXPIRACAO)))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
