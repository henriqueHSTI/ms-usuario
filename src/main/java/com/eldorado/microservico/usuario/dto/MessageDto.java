package com.eldorado.microservico.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {

    String to;
    String subject;
    String password;
    String message;

    @Override
    public String toString() {
        return "MessageDto{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
