package com.example.BTL_INTERNET_GT.DTO;

import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BillDTO {
    private String title;
    private Date create_At;
    private double totalPrice;
    private List<UserDTO> userDTOS = new ArrayList<>();
    private List<ItemDTO> itemDTOS = new ArrayList<>();
}
