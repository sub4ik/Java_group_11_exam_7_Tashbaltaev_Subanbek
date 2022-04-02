package com.example.delivery.dto;


import com.example.delivery.entity.Places;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PlacesDTO {

    public static PlacesDTO from(Places place) {
        return builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .build();
    }

    private Long id;
    private String name;
    private String description;
}
