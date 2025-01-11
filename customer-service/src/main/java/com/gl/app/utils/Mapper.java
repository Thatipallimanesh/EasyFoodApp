package com.gl.app.utils;

import com.gl.app.CustomerServiceApplication;
import com.gl.app.dto.CustomerDto;
import com.gl.app.entity.Customer;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
public class Mapper {

    // map the customer entity to customer dto
    public static CustomerDto mapToCustomerDto(Customer customer) {
        return CustomerServiceApplication.modelMapper().map(customer, CustomerDto.class);
    }

    // map the customer dto to customer entity
    public static Customer mapToCustomerEntity(CustomerDto customerDto) {
        return CustomerServiceApplication.modelMapper().map(customerDto, Customer.class);
    }

//    // map the food entity to food dto
//    public static FoodDto mapToFoodDto(Food food) {
//        return CustomerServiceApplication.modelMapper().map(food, FoodDto.class);
//    }
//
//    // map the food dto to food entity
//    public static Food mapToFoodEntity(FoodDto foodDto) {
//        return CustomerServiceApplication.modelMapper().map(foodDto, Food.class);
//    }
}
