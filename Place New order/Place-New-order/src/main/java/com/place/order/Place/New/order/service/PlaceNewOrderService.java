package com.place.order.Place.New.order.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.place.order.Place.New.order.model.CustomerOrder;
import com.place.order.Place.New.order.repository.CustomerOrderRepository;

@Service
public class PlaceNewOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	public ResponseEntity<Object> placeNewOrder(CustomerOrder customerOrder) 
	{
		try
		{
			String accoundId= "";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			customerOrder.getInfo().setTimeStamp(dtf.format(now));
			if(customerOrder.getAccountId()==null)
			{
				accoundId= generateAccountID(customerOrder.getAc());
				customerOrder.setAccountId(accoundId);
				
			}
			customerOrder.getInfo().setOrderId(generateOrderId());
			customerOrder.getInfo().setId(customerOrder.getAc()+customerOrder.getInfo().getOrderId());
			customerOrderRepository.save(customerOrder);
			return new ResponseEntity<Object>(customerOrder,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();

			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

	}
	private String generateAccountID(String accName)
	{
		String accNum= accName.substring(0,2);
		Random random= new Random();
		int num= random.nextInt();
		if(num<0)
		{
			num= num*-1;
		}
		num=num/10000;
		accNum= accNum+ String.valueOf(num);
		return accNum;
	}
	
	private String generateOrderId()
	{
		String orderId= "OID-";
		Random random= new Random();
		int num= random.nextInt();
		if(num<0)
		{
			num= num*-1;
		}
		num=num/10000;
		orderId= orderId+ String.valueOf(num);
		return orderId;
	}

}
