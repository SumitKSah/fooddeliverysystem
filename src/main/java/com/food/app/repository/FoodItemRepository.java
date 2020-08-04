package com.food.app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entity.FoodItemEntity;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItemEntity, Integer> {

	List<FoodItemEntity> findByNameContaining(String name);
}
