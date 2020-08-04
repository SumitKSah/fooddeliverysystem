package com.food.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food.app.entity.FoodOrderEntity;
import com.food.app.exception.ResourceNotFoundException;
import com.food.app.repository.FoodOrderRepository;
import com.food.app.service.FoodOrderService;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {
	
	@Autowired
	private FoodOrderRepository foodOrderRepository;

	@Override
	public void createOrder(FoodOrderEntity foodOrder) {
		// TODO Auto-generated method stub
		foodOrderRepository.save(foodOrder);
		
		
	}

	@Override
	public List<FoodOrderEntity> getOrderList() {
		List<FoodOrderEntity> orderList=new ArrayList<>();
		// TODO Auto-generated method stub
		foodOrderRepository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public FoodOrderEntity updateOrder(FoodOrderEntity foodOrder, Integer orderId) {
		
		return foodOrderRepository.findById(orderId).map(order->{
			order.setFoodIds(foodOrder.getFoodIds());
			order.setOrderStatus(foodOrder.getOrderStatus());
			order.setCity(order.getCity());
			order.setTotalAmount(foodOrder.getTotalAmount());
			return foodOrderRepository.save(order);
		}).orElseThrow(() -> new ResourceNotFoundException("FoodOrder " + orderId + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteOrder(Integer orderId) {
		
		return foodOrderRepository.findById(orderId).map(order -> {
			foodOrderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("FoodOrder " + orderId + " not found"));
	}

}
