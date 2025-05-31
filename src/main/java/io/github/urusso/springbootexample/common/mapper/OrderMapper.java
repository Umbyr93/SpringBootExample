package io.github.urusso.springbootexample.common.mapper;

import io.github.urusso.springbootexample.domain.order.dto.CreateOrderRequest;
import io.github.urusso.springbootexample.domain.order.dto.OrderResponse;
import io.github.urusso.springbootexample.persistence.model.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toResponse(OrderEntity source);
    List<OrderResponse> toResponseList(List<OrderEntity> source);
    OrderEntity toEntityFromCreateRequest(CreateOrderRequest source);
}
