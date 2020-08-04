package com.food.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.entity.FoodOrderEntity;
import com.food.app.service.BookingSummaryService;

@RestController
@CrossOrigin
@RequestMapping("/summay")
public class BookingSummaryController {

	@Autowired
	private BookingSummaryService bookingSummaryService;
	
	@PostMapping(value = "/bookingsummary")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<FoodOrderEntity> createFoodItem(@RequestBody FoodOrderEntity foodOrder) {
		return bookingSummaryService.getBookingSummary(foodOrder.getId(), foodOrder.getOrderStatus(), foodOrder.getOrderDate());
    }
	
}
