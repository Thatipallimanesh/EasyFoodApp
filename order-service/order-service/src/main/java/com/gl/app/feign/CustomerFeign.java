package com.gl.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerFeign {

    @GetMapping("/api/customer/get/{cId}")
    ResponseEntity<Boolean> getCustomer(@PathVariable int cId);

}
