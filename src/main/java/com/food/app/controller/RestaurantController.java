package com.food.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.entity.FoodItemEntity;
import com.food.app.entity.RestaurantEntity;
import com.food.app.service.RestaurantService;

@RestController
@CrossOrigin
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	
	@PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(@RequestBody RestaurantEntity restaurant) {
        restaurantService.createRestaurant(restaurant);
    }
	
	@GetMapping(value = "/{cityName}/search")
    public List<FoodItemEntity> searchByCity(@PathVariable("cityName") String cityName) {
        return restaurantService.getFoodListByCity(cityName);
    }
	
	@GetMapping(value = "/allcity")
    public List<String> searchByCity() {
        return restaurantService.getCityNames();
    }
}
