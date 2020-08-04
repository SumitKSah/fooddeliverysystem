package com.food.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.entity.OriginEntity;
import com.food.app.service.OriginSrevice;

@RestController
@CrossOrigin
@RequestMapping("/origin")
public class OriginController {

	@Autowired
	private OriginSrevice originSrevice;

	@PostMapping(value = "/orgin")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<OriginEntity> createFoodItem(@RequestBody OriginEntity originEntity) {

		return originSrevice.getOriginByPinCodeAndDestinationName(originEntity.getPinCode(), originEntity.getDestinationName());
	}

}
