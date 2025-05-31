package io.github.urusso.springbootexample.common.exception;

import io.github.urusso.springbootexample.common.constants.ErrorEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthorizationException extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;

    public AuthorizationException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
        this.httpStatus = errorEnum.getHttpStatus();
    }
}
