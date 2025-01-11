package com.gl.app.controller;

import com.gl.app.dto.FoodDto;
import com.gl.app.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@Validated
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<FoodDto> addFood(@Valid @RequestBody FoodDto foodDto) {
        FoodDto addedFood = foodService.addFood(foodDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedFood);
    }

    @PutMapping("/update/{fId}")
    public ResponseEntity<FoodDto> updateFood(@Valid @RequestBody FoodDto foodDto, @PathVariable int fId) {
        FoodDto updatedFood = foodService.updateFood(fId, foodDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFood);
    }

    @DeleteMapping("/delete/{fId}")
    public ResponseEntity<String> deleteFood(@PathVariable int fId) {
        foodService.deleteFood(fId);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted food with fId: " + fId);
    }

    @GetMapping("/food-list/{cLocation}")
    public ResponseEntity<List<FoodDto>> getFoodByLocation(@PathVariable String cLocation) {
        List<FoodDto> foodDtos = foodService.getFoodsByLocation(cLocation);
        return ResponseEntity.status(HttpStatus.OK).body(foodDtos);
    }

    @GetMapping("get/{fId}")
    public ResponseEntity<Boolean> getFood(@PathVariable int fId) {
        Boolean f = foodService.getFood(fId);
        return ResponseEntity.status(HttpStatus.OK).body(f);
    }

}
