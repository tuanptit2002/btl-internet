package com.example.BTL_INTERNET_GT.DTO;

import com.example.BTL_INTERNET_GT.Entity.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    private String describe;
    private Long total;
    private List<ItemDTO> itemDTOS = new ArrayList<>();
}
