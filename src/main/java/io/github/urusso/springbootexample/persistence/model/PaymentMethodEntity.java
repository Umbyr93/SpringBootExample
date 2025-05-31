package io.github.urusso.springbootexample.persistence.model;

import io.github.urusso.springbootexample.common.constants.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PAYMENT_METHODS")
public class PaymentMethodEntity {
    @Id
    private Long id; //No need for  @GeneratedValue, we won't add payment methods via API
    @Enumerated(EnumType.STRING)
    private PaymentMethod name;
    private LocalDateTime tsStartValidity;
    private LocalDateTime tsEndValidity;
}
