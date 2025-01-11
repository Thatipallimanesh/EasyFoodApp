package com.gl.app.service;

import com.gl.app.dto.FoodDto;

import java.util.List;

public interface FoodService {

    FoodDto addFood(FoodDto foodDto);

    FoodDto updateFood(int fId, FoodDto foodDto);

    void deleteFood(int fId);

    List<FoodDto> getFoodsByLocation(String location);

    Boolean getFood(int fId);

}
