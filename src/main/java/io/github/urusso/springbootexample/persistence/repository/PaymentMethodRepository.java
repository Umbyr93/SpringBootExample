package io.github.urusso.springbootexample.persistence.repository;

import io.github.urusso.springbootexample.persistence.model.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity,Long> {
}
