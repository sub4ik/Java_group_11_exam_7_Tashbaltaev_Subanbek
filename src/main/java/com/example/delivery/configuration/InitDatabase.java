package com.example.delivery.configuration;

import com.example.delivery.dataGenerate.GenerateData;
import com.example.delivery.dataGenerate.Generator;
import com.example.delivery.entity.Foods;
import com.example.delivery.entity.Orders;
import com.example.delivery.entity.Places;
import com.example.delivery.entity.Users;
import com.example.delivery.repository.FoodsRepository;
import com.example.delivery.repository.OrdersRepository;
import com.example.delivery.repository.PlacesRepository;
import com.example.delivery.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Configuration
public class InitDatabase {
    private static final Random r = new Random();


    private final FoodsRepository foodsRepository;
    private final OrdersRepository ordersRepository;
    private final PlacesRepository placesRepository;
    private final UsersRepository usersRepository;

    private List<Users> users = new ArrayList<>();
    private List<Foods> foods = new ArrayList<>();
    private List<Places> places = new ArrayList<>();
    private List<Orders> orders = new ArrayList<>();



    @Bean
    public CommandLineRunner fillData(){
        return (args) -> {
            foodsRepository.deleteAll();
            ordersRepository.deleteAll();
            placesRepository.deleteAll();
            usersRepository.deleteAll();

            users.add(Users.builder().name(GenerateData.randomPersonName()).email(GenerateData.randomEmail()).build());
            users.add(Users.builder().name(GenerateData.randomPersonName()).email(GenerateData.randomEmail()).build());
            users.add(Users.builder().name(GenerateData.randomPersonName()).email(GenerateData.randomEmail()).build());
            users.add(Users.builder().name(GenerateData.randomPersonName()).email(GenerateData.randomEmail()).build());
            users.add(Users.builder().name(GenerateData.randomPersonName()).email(GenerateData.randomEmail()).build());

            places.add(Places.builder().name(GenerateData.randomPlace().getName()).description(GenerateData.randomPlace().getDescription()).build());
            places.add(Places.builder().name(GenerateData.randomPlace().getName()).description(GenerateData.randomPlace().getDescription()).build());
            places.add(Places.builder().name(GenerateData.randomPlace().getName()).description(GenerateData.randomPlace().getDescription()).build());
            places.add(Places.builder().name(GenerateData.randomPlace().getName()).description(GenerateData.randomPlace().getDescription()).build());
            places.add(Places.builder().name(GenerateData.randomPlace().getName()).description(GenerateData.randomPlace().getDescription()).build());

            foods.add(Foods.builder().name(GenerateData.randomDish().getName()).type(GenerateData.randomDish().getType()).cost(5 + Math.random()*130).place(places.get(r.nextInt(places.size()))).build());
            foods.add(Foods.builder().name(GenerateData.randomDish().getName()).type(GenerateData.randomDish().getType()).cost(5 + Math.random()*130).place(places.get(r.nextInt(places.size()))).build());
            foods.add(Foods.builder().name(GenerateData.randomDish().getName()).type(GenerateData.randomDish().getType()).cost(5 + Math.random()*130).place(places.get(r.nextInt(places.size()))).build());
            foods.add(Foods.builder().name(GenerateData.randomDish().getName()).type(GenerateData.randomDish().getType()).cost(5 + Math.random()*130).place(places.get(r.nextInt(places.size()))).build());
            foods.add(Foods.builder().name(GenerateData.randomDish().getName()).type(GenerateData.randomDish().getType()).cost(5 + Math.random()*130).place(places.get(r.nextInt(places.size()))).build());

            orders.add(Orders.builder().user(users.get(r.nextInt(users.size()))).food(foods.get(r.nextInt(foods.size()))).build());
            orders.add(Orders.builder().user(users.get(r.nextInt(users.size()))).food(foods.get(r.nextInt(foods.size()))).build());
            orders.add(Orders.builder().user(users.get(r.nextInt(users.size()))).food(foods.get(r.nextInt(foods.size()))).build());
            orders.add(Orders.builder().user(users.get(r.nextInt(users.size()))).food(foods.get(r.nextInt(foods.size()))).build());
            orders.add(Orders.builder().user(users.get(r.nextInt(users.size()))).food(foods.get(r.nextInt(foods.size()))).build());

            usersRepository.saveAll(users);
            placesRepository.saveAll(places);
            foodsRepository.saveAll(foods);
            ordersRepository.saveAll(orders);
        };
    }
}
