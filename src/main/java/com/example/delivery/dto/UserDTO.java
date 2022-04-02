package com.example.delivery.dto;

import com.example.delivery.entity.Users;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    public static UserDTO from(Users user){
        return builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
