package com.gl.app.feign;

import com.gl.app.dto.FoodDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("FOOD-SERVICE")
public interface FoodFeign {

    @GetMapping("/api/food/food-list/{cLocation}")
    ResponseEntity<List<FoodDto>> getFoodsByLocation(@PathVariable String cLocation);

}
