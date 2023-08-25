package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.BillDTO;
import com.example.BTL_INTERNET_GT.DTO.ItemDTO;
import com.example.BTL_INTERNET_GT.DTO.UserDTO;
import com.example.BTL_INTERNET_GT.Entity.Bill;
import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Entity.User;
import com.example.BTL_INTERNET_GT.Repo.BillRepo;
import com.example.BTL_INTERNET_GT.Repo.ItemRepo;
import com.example.BTL_INTERNET_GT.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    BillRepo billRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ItemRepo itemRepo;

    public void create(BillDTO billDTO){
        Bill bill = new Bill();
        bill.setTitle(billDTO.getTitle());
        List<User> users = new ArrayList<>();
        for(UserDTO  userDTO : billDTO.getUserDTOS()){
            User user = new User();
            user.setFullName(userDTO.getUser_name());
            users.add(user);
        }
        bill.setUsers(users);
        List<Item> items = new ArrayList<>();
        for(ItemDTO itemDTO: billDTO.getItemDTOS()){
            Item item = new Item();
            item.setName(itemDTO.getName());
            items.add(item);
        }
        bill.setItems(items);
        bill.setTotalPrice(billDTO.getTotalPrice());
      billRepo.save(bill);
    }

}
