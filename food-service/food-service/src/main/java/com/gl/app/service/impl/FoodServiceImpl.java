package com.gl.app.service.impl;

import com.gl.app.dao.FoodDao;
import com.gl.app.dto.FoodDto;
import com.gl.app.entity.Food;
import com.gl.app.exception.ResourceNotFoundException;
import com.gl.app.service.FoodService;
import com.gl.app.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodDao foodDao;

    public FoodDto addFood(FoodDto foodDto) {
        Food food = Mapper.mapToFoodEntity(foodDto);
        Food addedFood = foodDao.save(food);
        return Mapper.mapToFoodDto(addedFood);
    }

    public FoodDto updateFood(int fId, FoodDto foodDto) {
        Food food = foodDao.findById(fId)
                .orElseThrow(() -> new ResourceNotFoundException("Food", "Id", fId));
        Food newFood = Mapper.mapToFoodEntity(foodDto);
        newFood.setFId(food.getFId());
        Food updatedFood = foodDao.save(newFood);
        return Mapper.mapToFoodDto(updatedFood);
    }

    public void deleteFood(int fId) {
        Food food = foodDao.findById(fId)
                .orElseThrow(() -> new ResourceNotFoundException("Food", "Id", fId));
        foodDao.deleteById(fId);
    }

    public List<FoodDto> getFoodsByLocation(String location) {
        List<Food> foods = foodDao.findByHotelAddress(location);
        List<FoodDto> foodDtos = new ArrayList<>();
        for (Food food : foods) foodDtos.add(Mapper.mapToFoodDto(food));
        return foodDtos;
    }

    public Boolean getFood(int fId) {
        Optional<Food> food = foodDao.findById(fId);
        return food.isPresent();
    }

}
