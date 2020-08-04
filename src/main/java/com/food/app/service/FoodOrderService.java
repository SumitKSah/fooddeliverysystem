package com.food.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.food.app.entity.FoodOrderEntity;

public interface FoodOrderService {

	void createOrder(FoodOrderEntity foodOrder);
	
	List<FoodOrderEntity> getOrderList();
	
	FoodOrderEntity updateOrder(FoodOrderEntity foodOder,Integer orderId);
	
	ResponseEntity<?> deleteOrder(Integer orderId);
}
