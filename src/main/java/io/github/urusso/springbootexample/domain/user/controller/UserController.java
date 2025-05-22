package io.github.urusso.springbootexample.domain.user.controller;

import io.github.urusso.springbootexample.common.constants.ApiConst;
import io.github.urusso.springbootexample.common.constants.SwaggerConst;
import io.github.urusso.springbootexample.domain.user.service.UserService;
import io.github.urusso.springbootexample.persistence.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.USER_API)
@Tag(name = SwaggerConst.USER_TAG_NAME, description = SwaggerConst.USER_TAG_DESC)
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get all users", description = "Retrieve all users from the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users successfully retrieved")
    })
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> response = userService.getAllOrders();
        return ResponseEntity.ok(response);
    }
}
