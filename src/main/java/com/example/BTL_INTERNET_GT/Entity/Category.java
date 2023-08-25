package com.example.BTL_INTERNET_GT.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String describeItem;
    private Long totalItem;
    @OneToMany(mappedBy = "category")
    private List<Item> items = new ArrayList<>();


}
