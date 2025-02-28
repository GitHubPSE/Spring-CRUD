package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
}