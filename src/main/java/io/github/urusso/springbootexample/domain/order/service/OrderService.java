package io.github.urusso.springbootexample.domain.order.service;

import io.github.urusso.springbootexample.common.mapper.OrderMapper;
import io.github.urusso.springbootexample.domain.order.dto.OrderResponse;
import io.github.urusso.springbootexample.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> getAllOrders(Long userId) {
        return orderMapper.toResponseList(orderRepository.findByUserId(userId));
    }
}
