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
import com.food.app.service.FoodItemService;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodItemController {

	@Autowired
	private FoodItemService foodItemService;
	
	@PostMapping(value = "/{rid}/bulksave")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMultiFoodItem(@RequestBody List<FoodItemEntity> foodItem, @PathVariable("rid") Integer id) {
		foodItemService.bulkInsert(foodItem, id);
    }
	
	@PostMapping(value = "/{rid}/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createFoodItem(@RequestBody FoodItemEntity foodItem, @PathVariable("rid") Integer id) {
		foodItemService.createFoodItem(foodItem, id);
    }
	
	@GetMapping(value = "/{name}/search")
    public List<FoodItemEntity> searchFood( @PathVariable("name") String name) {
		return foodItemService.searchFoodAndRestaurantByName(name);
    }
	
	
}
