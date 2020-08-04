package com.food.app.service;

import org.springframework.stereotype.Service;

@Service
public interface ComponentDetailsService {

	boolean createComponentDetails(final String applicationName);

	//PairedComponentDetailsBean findAll(final String applicationName);

}
