package com.eldorado.microservico.usuario.service;


import com.eldorado.microservico.usuario.domain.model.UserEntity;
import com.eldorado.microservico.usuario.dto.MessageDto;
import com.eldorado.microservico.usuario.dto.UserDto;
import com.eldorado.microservico.usuario.repository.UserRepository;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final String MESSAGE = "Cadastro realizado\nUsuario: %s\nSenha: %s";
    private final String SUBJECT = "NÃO RESPONDA";

    public UserDto createUser(@Validated UserDto userDto) {
        var userEntity = modelMapper.map(userDto, UserEntity.class);

        var password = passwordGeneretor();

        userEntity.setPassword(Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString());

        userEntity = userRepository.save(userEntity);
        log.info("User Saved with sucefull {}", userEntity);

        sendMessage(userDto, password);

        return userDto;
    }

    private void sendMessage(UserDto userDto, String password) {
        var message = MessageDto
                .builder()
                .to(userDto.getEmail())
                .message(String.format(MESSAGE, userDto.getEmail(), password))
                .subject(SUBJECT)
                .build();

        log.info("Message to queue {}", message);
    }

    private String passwordGeneretor() {
        RandomStringUtils.randomAlphabetic(10);
        return Base64.encodeBase64String(RandomStringUtils.randomAlphanumeric(10).getBytes());
    }
}
