package com.food.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.food.app.service.ComponentDetailsService;

@EnableAsync
@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = { "com.food" })
@PropertySources({ @PropertySource(value = "classpath:db-config.properties"),
		@PropertySource(value = "classpath:${k8s.db.env}.properties", ignoreResourceNotFound = true) })
public class FoodDeliveryApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(FoodDeliveryApplication.class, args);
		context.getBean(ComponentDetailsService.class)
				.createComponentDetails(context.getEnvironment().getProperty("spring.application.name"));
	}
 
}
