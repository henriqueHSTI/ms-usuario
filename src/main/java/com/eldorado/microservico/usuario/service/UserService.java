package com.eldorado.microservico.usuario.service;


import com.eldorado.commons.dto.UserLoginDto;
import com.eldorado.commons.exceptions.NotFoundException;
import com.eldorado.microservico.usuario.domain.model.UserEntity;
import com.eldorado.microservico.usuario.dto.MessageDto;
import com.eldorado.microservico.usuario.dto.UserDto;
import com.eldorado.microservico.usuario.publisher.UserPublisher;
import com.eldorado.microservico.usuario.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private static final String MESSAGE = "Cadastro realizado\nUsuario: %s\nSenha: %s";
    private static final String SUBJECT = "NÃO RESPONDA";

    private final ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    private final UserRepository userRepository;

    private final UserPublisher userPublisher;
    private final PasswordEncoder passwordEncoder;


    public UserDto createUser(@Validated UserDto userDto) {
        var userEntity = modelMapper.map(userDto, UserEntity.class);

        var password = passwordGeneretor();
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity = userRepository.save(userEntity);
        log.info("User Saved with sucefull {}", userEntity);
        sendMessage(userDto, password);

        return userDto;
    }

    @SneakyThrows
    private void sendMessage(UserDto userDto, String password) {
        var message = MessageDto.builder().to(userDto.getUserName()).message(String.format(MESSAGE, userDto.getUserName(), password)).subject(SUBJECT).build();

        userPublisher.sendToQueue(objectMapper.writeValueAsString(message));
        log.info("Message to queue {}", message);
    }

    private String passwordGeneretor() {
        RandomStringUtils.randomAlphabetic(10);
        return Base64.encodeBase64String(RandomStringUtils.randomAlphanumeric(10).getBytes());
    }

    @SneakyThrows
    public UserDto login(UserLoginDto userLoginDto) {

        log.info("Retrieve information to login {}", userLoginDto.getUserName());

        var user = userRepository.findByUserName(userLoginDto.getUserName())
                .orElseThrow(() -> new NotFoundException("Invalid Access"));

        return modelMapper.map(user, UserDto.class);


    }
}
