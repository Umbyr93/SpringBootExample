package io.github.urusso.springbootexample.persistence.repository;

import io.github.urusso.springbootexample.persistence.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByUserId(Long userId);
}
