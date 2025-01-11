package com.gl.app.service.impl;

import com.gl.app.dao.OrderDao;
import com.gl.app.dto.OrderDto;
import com.gl.app.entity.Order;
import com.gl.app.exception.ResourceNotFoundException;
import com.gl.app.feign.CustomerFeign;
import com.gl.app.feign.FoodFeign;
import com.gl.app.service.OrderService;
import com.gl.app.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    CustomerFeign customerFeign;

    @Autowired
    FoodFeign foodFeign;

    public OrderDto placeOrder(OrderDto orderDto) {
        Boolean a = customerFeign.getCustomer(orderDto.getCId()).getBody();
        if (Boolean.FALSE.equals(a)) throw new ResourceNotFoundException("Customer", "Id", orderDto.getCId());
        Boolean b = foodFeign.getFood(orderDto.getFId()).getBody();
        if (Boolean.FALSE.equals(b)) throw new ResourceNotFoundException("Food", "Id", orderDto.getFId());
        Order order = Mapper.mapToOrderEntity(orderDto);
        Order placedOrder = orderDao.save(order);
        return Mapper.mapToOrderDto(placedOrder);
    }

    public List<OrderDto> getOrdersByDay() {
        return orderDao.findAll().stream()
                .filter(order -> order.getDate().isEqual(LocalDate.now()))
                .map(order -> Mapper.mapToOrderDto(order)).toList();
    }

    public List<OrderDto> getOrdersByWeek() {
        return orderDao.findAll().stream()
                .filter(order -> order.getDate().isAfter(LocalDate.now().minusDays(7)))
                .map(order -> Mapper.mapToOrderDto(order)).toList();
    }

    public List<OrderDto> getOrdersByMonth() {
        return orderDao.findAll().stream()
                .filter(order -> order.getDate().getMonth() == LocalDate.now().getMonth())
                .map(order -> Mapper.mapToOrderDto(order)).toList();
    }

}
