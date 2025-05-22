package io.github.urusso.springbootexample.persistence.repository;

import io.github.urusso.springbootexample.persistence.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
