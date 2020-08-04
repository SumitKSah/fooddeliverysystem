package com.food.app.service;

import java.util.List;

import com.food.app.entity.FoodItemEntity;
import com.food.app.entity.RestaurantEntity;

public interface RestaurantService {
	
    void createRestaurant(RestaurantEntity restaurant);
    
    List<FoodItemEntity> getFoodListByCity(String cityName);
    
    List<String> getCityNames();
   
}
