package com.place.order.Place.New.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.place.order.Place.New.order.model.CustomerOrder;
import com.place.order.Place.New.order.service.PlaceNewOrderService;
import com.place.order.Place.New.order.service.SchedulerService;

@RestController
@RequestMapping("/placeNewOrder")
public class PlaceNewOrderController {
	
	@Autowired
	private PlaceNewOrderService placeNewOrderService;
	
	@Autowired
	private SchedulerService schedulerService;
	
	
	
	@RequestMapping(value = {"/createNewOrder"}, method = RequestMethod.POST)
	public ResponseEntity<Object> createNewOrder(@RequestBody CustomerOrder customerOrder)
	{
		ResponseEntity<Object> response = null;
		try {
			response = placeNewOrderService.placeNewOrder(customerOrder);
			
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
	
	@RequestMapping(value = {"/cronJob"}, method = RequestMethod.POST)
	public ResponseEntity<Object> cronJob()
	{
		try
		{
			schedulerService.cronJob();
			
			
			return new ResponseEntity<Object>("success",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return new ResponseEntity<Object>("Bad Request", HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
