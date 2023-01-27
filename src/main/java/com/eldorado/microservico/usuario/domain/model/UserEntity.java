package com.eldorado.microservico.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class UserEntity {

    @Id
    private String document;
    @NonNull
    private String name;
    private char gender;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String userName;
    private String password;

    private AddressEntity addressEntity;

    @Override
    public String toString() {
        return "UserEntity{" +
                "document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", email='" + userName + '\'' +
                '}';
    }
}
