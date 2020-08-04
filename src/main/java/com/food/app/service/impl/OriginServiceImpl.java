package com.food.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.entity.OriginEntity;
import com.food.app.repository.OriginRepository;
import com.food.app.service.OriginSrevice;

@Service
public class OriginServiceImpl implements OriginSrevice {

	@Autowired
	private OriginRepository originRepository;

	@Override
	public List<OriginEntity> getOriginByPinCodeAndDestinationName(Integer pinCode, String destinationName) {
		// TODO Auto-generated method stub

		return originRepository.findByPinCodeAndDestinationName(pinCode, destinationName);
	}

}
