package com.food.app.service;

import java.util.List;

import com.food.app.entity.FoodItemEntity;

public interface FoodItemService {
	
    void createFoodItem(FoodItemEntity foodItem,int restaurantId);
    
    void bulkInsert(List<FoodItemEntity> foodItemList,int restaurantId);
    
    List<FoodItemEntity> searchFoodAndRestaurantByName(String name);
}
