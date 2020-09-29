package com.place.order.Place.New.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.place.order.Place.New.order.model.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, String>{

}
