package io.github.urusso.springbootexample.domain.user.dto;

import io.github.urusso.springbootexample.common.constants.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResponse {
    private Long userId;
    private String username;
    private String email;
    private PaymentMethod defaultPaymentMethod;
    private String jwtToken;
}
