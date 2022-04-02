package com.example.delivery.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Entity
@Table(name = "foods")
public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(name = "cost")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Places place;


}
