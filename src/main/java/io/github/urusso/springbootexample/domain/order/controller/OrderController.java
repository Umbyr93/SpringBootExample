package io.github.urusso.springbootexample.domain.order.controller;

import io.github.urusso.springbootexample.common.constants.ApiConst;
import io.github.urusso.springbootexample.common.constants.SwaggerConst;
import io.github.urusso.springbootexample.domain.order.service.OrderService;
import io.github.urusso.springbootexample.persistence.model.OrderEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.ORDER_API)
@Tag(name = SwaggerConst.ORDER_TAG_NAME, description = SwaggerConst.ORDER_TAG_DESC)
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "Get all orders", description = "Retrieve all order from the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Orders successfully retrieved")
    })
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> response = orderService.getAllOrders();
        return ResponseEntity.ok(response);
    }
}
