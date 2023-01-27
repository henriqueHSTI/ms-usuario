package com.eldorado.microservico.usuario.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {

    private HttpStatus status;
    private String message;
    private List<String> errors;

}
