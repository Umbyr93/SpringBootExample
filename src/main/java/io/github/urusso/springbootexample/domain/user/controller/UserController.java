package io.github.urusso.springbootexample.domain.user.controller;

import io.github.urusso.springbootexample.common.constants.ApiConst;
import io.github.urusso.springbootexample.common.constants.SwaggerConst;
import io.github.urusso.springbootexample.domain.user.dto.CreateUserRequest;
import io.github.urusso.springbootexample.domain.user.dto.CreateUserResponse;
import io.github.urusso.springbootexample.domain.user.dto.LoginUserRequest;
import io.github.urusso.springbootexample.domain.user.dto.LoginUserResponse;
import io.github.urusso.springbootexample.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.USER_API)
@Tag(name = SwaggerConst.USER_TAG_NAME, description = SwaggerConst.USER_TAG_DESC)
public class UserController {
    private final UserService userService;

    @Operation(summary = "Create user", description = "API to create the user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User successfully created")
    })
    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        CreateUserResponse createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }

    @Operation(summary = "Login user", description = "API for the user authentication")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User logged in")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(@Valid @RequestBody LoginUserRequest request) {
        LoginUserResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
