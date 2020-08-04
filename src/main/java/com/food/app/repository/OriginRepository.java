package com.food.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entity.OriginEntity;

@Repository
public interface OriginRepository extends CrudRepository<OriginEntity, Integer> {

	List<OriginEntity> findByPinCodeAndDestinationName(Integer pinCode, String destinationName);
}
