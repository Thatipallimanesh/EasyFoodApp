package com.gl.app.dao;

import com.gl.app.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodDao extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT * FROM food WHERE hotel_address =:address", nativeQuery = true)
    List<Food> findByHotelAddress(String address);

}
