package com.food.app.service;

import java.util.Date;
import java.util.List;

import com.food.app.entity.FoodOrderEntity;

public interface BookingSummaryService {
   
	List<FoodOrderEntity> getBookingSummary(Integer orderId, String orderStatus,Date orderDate);
}
