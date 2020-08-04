package com.food.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.entity.FoodItemEntity;
import com.food.app.entity.RestaurantEntity;
import com.food.app.repository.RestaurantRespository;
import com.food.app.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRespository restaurantRepository;

	@Override
	public void createRestaurant(RestaurantEntity restaurant) {
		// TODO Auto-generated method stub
		restaurantRepository.save(restaurant);
	}

	@Override
	public List<FoodItemEntity> getFoodListByCity(String cityName) {
		// TODO Auto-generated method stub
		List<FoodItemEntity> foodList = new ArrayList<>();
		List<RestaurantEntity> restaurantList = restaurantRepository.findByCity(cityName);
		restaurantList.stream().map(r -> r.getFoods()).forEach(foodList::addAll);
		
		return foodList;
	}

	@Override
	public List<String> getCityNames() {
		// TODO Auto-generated method stub
		//return restaurantRepository.findDistinctCity();
		return null;
	}

}
