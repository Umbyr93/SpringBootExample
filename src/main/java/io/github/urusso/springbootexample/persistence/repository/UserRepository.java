package io.github.urusso.springbootexample.persistence.repository;

import io.github.urusso.springbootexample.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
