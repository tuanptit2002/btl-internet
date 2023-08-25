package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.ItemDTO;
import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    private void create(ItemDTO itemDTO){
        Item item = new Item();
        item.setPrice(itemDTO.getPrice());
        item.setName(itemDTO.getName());
    }
    private void  update(ItemDTO itemDTO){
        Item item = itemRepo.findById(itemDTO.getId()).orElseThrow(() -> new RuntimeException("Item Valid"));
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
    }
    private void delete(Long id){
        itemRepo.deleteById(id);
    }
}
