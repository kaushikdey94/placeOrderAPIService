package com.place.order.Place.New.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.place.order.Place.New.order.model.CustomerOrder;
import com.place.order.Place.New.order.repository.CustomerOrderRepository;

@Service
public class SchedulerService {
	
	@Autowired
	private PlaceNewOrderService placeNewOrderService;
	
	/*
	 * @Autowired private CustomerOrder CustomerOrder;
	 */
	
	@Autowired
	private CustomerOrderRepository custRepo;
	@Scheduled(cron = "0 */15 * ? * *")
	public void cronJob()
	{
		try
		{
			List<CustomerOrder> custOrder= custRepo.findAll();
			int size=custOrder.size();
		placeNewOrderService.placeNewOrder(custOrder.get(size-1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}

}
