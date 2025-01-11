package com.gl.app.service.impl;

import com.gl.app.dao.CustomerDao;
import com.gl.app.dto.CustomerDto;
import com.gl.app.dto.FoodDto;
import com.gl.app.entity.Customer;
import com.gl.app.exception.ResourceNotFoundException;
import com.gl.app.feign.FoodFeign;
import com.gl.app.service.CustomerService;
import com.gl.app.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    FoodFeign foodFeign;

    public List<FoodDto> getFoodList(String cLocation) {
        List<FoodDto> foodDtos = foodFeign.getFoodsByLocation(cLocation).getBody();
        if (foodDtos == null) throw new ResourceNotFoundException("Food", "location", cLocation);
        return foodDtos;
    }

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = Mapper.mapToCustomerEntity(customerDto);
        Customer addedCustomer = customerDao.save(customer);
        return Mapper.mapToCustomerDto(addedCustomer);
    }

    public Boolean getCustomer(int cId) {
        Optional<Customer> customer = customerDao.findById(cId);
        return customer.isPresent();
    }

}
