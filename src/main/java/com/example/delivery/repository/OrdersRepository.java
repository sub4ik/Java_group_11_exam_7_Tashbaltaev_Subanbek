package com.example.delivery.repository;

import com.example.delivery.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, String> {

}
