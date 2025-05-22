package io.github.urusso.springbootexample.domain.order.service;

import io.github.urusso.springbootexample.persistence.model.OrderEntity;
import io.github.urusso.springbootexample.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
