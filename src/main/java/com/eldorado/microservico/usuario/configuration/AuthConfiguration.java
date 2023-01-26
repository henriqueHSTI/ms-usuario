package com.eldorado.microservico.usuario.configuration;

import com.eldorado.commons.security.AuthUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

    public AuthUtils authUtils() {
        return new AuthUtils();
    }
}
