package com.place.order.Place.New.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlaceNewOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceNewOrderApplication.class, args);
	}

}
