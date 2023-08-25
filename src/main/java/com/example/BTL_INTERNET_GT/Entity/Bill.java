package com.example.BTL_INTERNET_GT.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date create_At;
    private double totalPrice;
    @ManyToMany
    @JoinTable(name = "user_bill", joinColumns = @JoinColumn(name = "bill_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "item_bill", joinColumns = @JoinColumn(name = "bill_id"),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();
}
