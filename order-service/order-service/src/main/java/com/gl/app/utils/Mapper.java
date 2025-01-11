package com.gl.app.utils;

import com.gl.app.OrderServiceApplication;
import com.gl.app.dto.OrderDto;
import com.gl.app.entity.Order;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
public class Mapper {

    // map the order entity to order dto
    public static OrderDto mapToOrderDto(Order order) {
        return OrderServiceApplication.modelMapper().map(order, OrderDto.class);
    }

    // map the order dto to order entity
    public static Order mapToOrderEntity(OrderDto orderDto) {
        return OrderServiceApplication.modelMapper().map(orderDto, Order.class);
    }
}
