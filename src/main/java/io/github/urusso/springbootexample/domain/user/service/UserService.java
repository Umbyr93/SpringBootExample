package io.github.urusso.springbootexample.domain.user.service;

import io.github.urusso.springbootexample.persistence.model.UserEntity;
import io.github.urusso.springbootexample.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getAllOrders() {
        return userRepository.findAll();
    }
}
