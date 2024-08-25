package com.example.start.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;
    private Integer stock;
}
