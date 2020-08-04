package com.food.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.entity.FoodItemEntity;
import com.food.app.entity.RestaurantEntity;
import com.food.app.repository.FoodItemRepository;
import com.food.app.repository.RestaurantRespository;
import com.food.app.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	
	@Autowired
    private FoodItemRepository foodItemRepository;
	
	@Autowired
	private RestaurantRespository restaurantRepository;

	@Override
	public void createFoodItem(FoodItemEntity foodItem, int restaurantId) {
		// TODO Auto-generated method stub
		boolean exist=restaurantRepository.existsById(restaurantId);
		if(exist) {
			RestaurantEntity restaurant=new RestaurantEntity();
			restaurant.setId(restaurantId);
			foodItem.setRestaurant(restaurant);
			foodItemRepository.save(foodItem);
		}
	}

	@Override
	public void bulkInsert(List<FoodItemEntity> foodItemList, int restaurantId) {
		// TODO Auto-generated method stub
		boolean exist=restaurantRepository.existsById(restaurantId);
		if(exist) {
			RestaurantEntity restaurant=new RestaurantEntity();
			restaurant.setId(restaurantId);
			foodItemList.forEach(item->item.setRestaurant(restaurant));
			foodItemRepository.saveAll(foodItemList);
		}
	}

	@Override
	public List<FoodItemEntity> searchFoodAndRestaurantByName(String name) {
		// TODO Auto-generated method stub
		
		List<FoodItemEntity> foodList = new ArrayList<>();
		List<RestaurantEntity> resturantNames = restaurantRepository.findByNameContaining(name);
		resturantNames.stream().map(r -> r.getFoods()).forEach(foodList::addAll);	
		List<FoodItemEntity> foodListByFoodName=foodItemRepository.findByNameContaining(name);		
		foodList.addAll(foodListByFoodName);
		
		return foodList.stream().distinct().collect(Collectors.toList());
	}


	

}
