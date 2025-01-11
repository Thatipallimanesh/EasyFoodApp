package com.gl.app.controller;

import com.gl.app.dto.OrderDto;
import com.gl.app.exception.ResourceNotFoundException;
import com.gl.app.feign.CustomerFeign;
import com.gl.app.feign.FoodFeign;
import com.gl.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto) {
        OrderDto placedOrder = orderService.placeOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(placedOrder);
    }

    @GetMapping("/list/day")
    public ResponseEntity<List<OrderDto>> getOrdersByDay() {
        List<OrderDto> orderDtos = orderService.getOrdersByDay();
        return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
    }

    @GetMapping("/list/week")
    public ResponseEntity<List<OrderDto>> getOrdersByWeek() {
        List<OrderDto> orderDtos = orderService.getOrdersByWeek();
        return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
    }

    @GetMapping("/list/month")
    public ResponseEntity<List<OrderDto>> getOrdersByMonth() {
        List<OrderDto> orderDtos = orderService.getOrdersByMonth();
        return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
    }

}
