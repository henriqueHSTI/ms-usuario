package com.eldorado.microservico.usuario.repository;

import com.eldorado.microservico.usuario.domain.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
