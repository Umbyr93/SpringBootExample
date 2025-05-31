package io.github.urusso.springbootexample.common.mapper;

import io.github.urusso.springbootexample.domain.user.dto.CreateUserRequest;
import io.github.urusso.springbootexample.domain.user.dto.LoginUserResponse;
import io.github.urusso.springbootexample.persistence.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "defaultPaymentMethod.name", target = "defaultPaymentMethod")
    LoginUserResponse toResponse(UserEntity source);
    List<LoginUserResponse> toResponseList(List<UserEntity> source);
    UserEntity toEntityFromCreateRequest(CreateUserRequest source);
}
