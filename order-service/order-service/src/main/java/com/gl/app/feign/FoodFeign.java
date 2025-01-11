package com.gl.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FOOD-SERVICE")
public interface FoodFeign {

    @GetMapping("/api/food/get/{fId}")
    ResponseEntity<Boolean> getFood(@PathVariable int fId);

}
