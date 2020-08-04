package com.food.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entity.FoodOrderEntity;

@Repository
public interface FoodOrderRepository extends CrudRepository<FoodOrderEntity, Integer> {
	
	List<FoodOrderEntity> findByIdAndOrderStatusAndOrderDate(Integer orderId, String orderStatus, Date orderDate);
	

}
