package com.gl.app.service;

import com.gl.app.dto.CustomerDto;
import com.gl.app.dto.FoodDto;

import java.util.List;

public interface CustomerService {

    List<FoodDto> getFoodList(String cLocation);

    CustomerDto addCustomer(CustomerDto customerDto);

    Boolean getCustomer(int cId);

}
