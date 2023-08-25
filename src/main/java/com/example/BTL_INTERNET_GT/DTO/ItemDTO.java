package com.example.BTL_INTERNET_GT.DTO;

import com.example.BTL_INTERNET_GT.Entity.Category;
import com.example.BTL_INTERNET_GT.Entity.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDTO {
    private Long id;
    private double price;
    private String name;
    private CategoryDTO categoryDTO ;
    private List<BillDTO> billDTOS = new ArrayList<>();
}
