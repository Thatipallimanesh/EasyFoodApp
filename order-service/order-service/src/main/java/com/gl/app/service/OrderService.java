package com.gl.app.service;

import com.gl.app.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto placeOrder(OrderDto orderDto);

    List<OrderDto> getOrdersByDay();

    List<OrderDto> getOrdersByWeek();

    List<OrderDto> getOrdersByMonth();

}
