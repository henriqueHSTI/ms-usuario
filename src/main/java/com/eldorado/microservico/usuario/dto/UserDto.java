package com.eldorado.microservico.usuario.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    @NonNull
    private String name;
    private char gender;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String document;
    @NonNull
    private String email;

    private AddressDto addressDto;


}
