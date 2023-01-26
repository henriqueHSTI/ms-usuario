package com.eldorado.microservico.usuario.controller;

import com.eldorado.commons.header.ApiEldoradoDefaultHeader;
import com.eldorado.microservico.usuario.dto.UserDto;
import com.eldorado.microservico.usuario.security.AuthUtils;
import com.eldorado.microservico.usuario.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final AuthUtils authUtils;

    private final UserService userService;

    @PostMapping

    @ApiEldoradoDefaultHeader
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }
}
