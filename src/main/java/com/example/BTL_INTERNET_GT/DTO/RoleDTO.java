package com.example.BTL_INTERNET_GT.DTO;

import com.example.BTL_INTERNET_GT.Entity.User;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDTO {
    private String name;
    private String description;
    private Date created_At;
    private Date updated_At;
    private Set<UserDTO> users = new HashSet<>();
}
