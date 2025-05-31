package io.github.urusso.springbootexample.domain.user.service;

import io.github.urusso.springbootexample.common.constants.ErrorEnum;
import io.github.urusso.springbootexample.common.exception.AuthorizationException;
import io.github.urusso.springbootexample.common.mapper.UserMapper;
import io.github.urusso.springbootexample.common.service.JwtService;
import io.github.urusso.springbootexample.domain.user.dto.CreateUserRequest;
import io.github.urusso.springbootexample.domain.user.dto.CreateUserResponse;
import io.github.urusso.springbootexample.domain.user.dto.LoginUserRequest;
import io.github.urusso.springbootexample.domain.user.dto.LoginUserResponse;
import io.github.urusso.springbootexample.persistence.model.UserEntity;
import io.github.urusso.springbootexample.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public CreateUserResponse createUser(CreateUserRequest request) {
        UserEntity createEntity = userMapper.toEntityFromCreateRequest(request);
        createEntity.setPassword(ENCODER.encode(request.password()));

        UserEntity savedEntity = userRepository.save(createEntity);
        return new CreateUserResponse(savedEntity.getId());
    }

    public LoginUserResponse login(LoginUserRequest request) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(request.username());
        UserEntity user = userOpt.orElseThrow(() -> new AuthorizationException(ErrorEnum.USER_NOT_FOUND));

        if(!ENCODER.matches(request.password(), user.getPassword()))
            throw new AuthorizationException(ErrorEnum.WRONG_PASSWORD);

        LoginUserResponse response = userMapper.toResponse(user);
        response.setJwtToken(jwtService.generateToken(response.getUsername()));
        return response;
    }
}
