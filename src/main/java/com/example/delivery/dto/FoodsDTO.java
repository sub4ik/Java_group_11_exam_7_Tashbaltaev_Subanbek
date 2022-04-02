package com.example.delivery.dto;


import com.example.delivery.entity.Foods;
import com.example.delivery.entity.Places;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodsDTO {
    public static FoodsDTO from(Foods foods){
        return builder()
                .id(foods.getId())
                .name(foods.getName())
                .type(foods.getType())
                .cost(foods.getCost())
                .place(foods.getPlace())
                .build();
    }

    private Long id;
    private String name;
    private String type;
    private Double cost;
    private Places place;
}
