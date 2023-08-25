package com.example.BTL_INTERNET_GT.DTO;

import com.example.BTL_INTERNET_GT.Entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class UserDTO {
    private String user_name;
    private String email;
    private String password;
    private String mobile_number;
    private Set<Role> roles = new HashSet<>();
}
