package com.example.delivery.repository;


import com.example.delivery.entity.Foods;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodsRepository extends PagingAndSortingRepository<Foods, String> {

}
