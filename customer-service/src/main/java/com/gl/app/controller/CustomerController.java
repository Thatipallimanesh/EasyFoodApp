package com.gl.app.controller;

import com.gl.app.dto.CustomerDto;
import com.gl.app.dto.FoodDto;
import com.gl.app.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/food-list/{cLocation}")
    public ResponseEntity<List<FoodDto>> getFoodListByLocation(@PathVariable String cLocation) {
        List<FoodDto> foodDtos = customerService.getFoodList(cLocation);
        return ResponseEntity.status(HttpStatus.OK).body(foodDtos);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto addedCustomer = customerService.addCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(addedCustomer);
    }

    @GetMapping("/get/{cId}")
    public ResponseEntity<Boolean> getCustomer(@PathVariable int cId) {
        Boolean f = customerService.getCustomer(cId);
        return ResponseEntity.status(HttpStatus.OK).body(f);
    }

}
