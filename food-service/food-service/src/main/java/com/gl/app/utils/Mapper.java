package com.gl.app.utils;

import com.gl.app.FoodServiceApplication;
import com.gl.app.dto.FoodDto;
import com.gl.app.entity.Food;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
public class Mapper {

    // map the food entity to food dto
    public static FoodDto mapToFoodDto(Food food) {
        return FoodServiceApplication.modelMapper().map(food, FoodDto.class);
    }

    // map the food dto to food entity
    public static Food mapToFoodEntity(FoodDto foodDto) {
        return FoodServiceApplication.modelMapper().map(foodDto, Food.class);
    }
}
