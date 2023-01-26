package com.eldorado.microservico.usuario.controller;

import com.eldorado.microservico.usuario.dto.UserDto;
import com.eldorado.microservico.usuario.security.AuthUtils;
import com.eldorado.microservico.usuario.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final AuthUtils authUtils;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, @RequestHeader String authorization) {
        log.info(authorization);
        authorization = authorization.replace("Bearer ", "");
        authUtils.validateJwtToken(authorization);
        return ResponseEntity.ok(userService.createUser(userDto));
    }
}
