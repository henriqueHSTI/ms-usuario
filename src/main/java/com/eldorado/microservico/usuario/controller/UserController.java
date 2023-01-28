package com.eldorado.microservico.usuario.controller;

import com.eldorado.commons.dto.UserLoginDto;
import com.eldorado.microservico.usuario.dto.UserDto;
import com.eldorado.microservico.usuario.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> getLogin(@RequestBody UserLoginDto loginDto) {

        return ResponseEntity.ok(userService.login(loginDto));
    }

    @GetMapping("/test")
    public ResponseEntity<String> getTest(@RequestBody UserLoginDto userLoginDto) {
        return ResponseEntity.ok("Isso é Um teste");
    }
}
