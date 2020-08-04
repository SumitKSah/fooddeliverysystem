package com.food.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.entity.FoodOrderEntity;
import com.food.app.service.FoodOrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private FoodOrderService foodOrderService;
	
	@PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createFoodOrder(@RequestBody FoodOrderEntity foodOrder) {
		foodOrderService.createOrder(foodOrder);
    }
	
	@PutMapping("/update/{orderId}")
    public FoodOrderEntity updateFoodOrder(@PathVariable Integer orderId, @RequestBody FoodOrderEntity foodOrder) {
       return foodOrderService.updateOrder(foodOrder, orderId);
	}
	
	@DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {
        return foodOrderService.deleteOrder(orderId);
	}
	
}
