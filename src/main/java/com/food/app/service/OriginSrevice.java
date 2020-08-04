package com.food.app.service;

import java.util.List;

import com.food.app.entity.OriginEntity;

public interface OriginSrevice {

	List<OriginEntity> getOriginByPinCode(Integer pinCode, String destinationName);

}
