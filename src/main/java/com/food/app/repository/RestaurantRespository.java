package com.food.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entity.RestaurantEntity;

@Repository
public interface RestaurantRespository extends CrudRepository<RestaurantEntity, Integer>{

	List<RestaurantEntity> findByNameContaining(String name);
	
	List<RestaurantEntity> findByCity(String city);
	
//	@Query("SELECT DISTINCT r.city FROM Restaurant r")
//	List<String> findDistinctCity();
}
