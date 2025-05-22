package io.github.urusso.springbootexample.persistence.repository;

import io.github.urusso.springbootexample.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
