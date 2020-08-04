package com.food.app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.entity.FoodOrderEntity;
import com.food.app.repository.FoodOrderRepository;
import com.food.app.service.BookingSummaryService;

@Service
public class BookingSummaryImp implements BookingSummaryService {

	@Autowired
	private FoodOrderRepository foodOrderRepository;

	@Override
	public List<FoodOrderEntity> getBookingSummary(Integer orderId, String orderStatus, Date orderDate) {
		// TODO Auto-generated method stub

		 
		 return foodOrderRepository.findByIdAndOrderStatusAndOrderDate(orderId, orderStatus, orderDate);
	}

}
