package com.example.BTL_INTERNET_GT.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
    @ManyToMany(mappedBy = "items")
    private List<Bill> bill = new ArrayList<>();
}
