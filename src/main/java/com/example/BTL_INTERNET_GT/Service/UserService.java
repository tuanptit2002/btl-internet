package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.UserDTO;
import com.example.BTL_INTERNET_GT.Entity.Role;
import com.example.BTL_INTERNET_GT.Entity.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String username, String rolename);
    void singup(UserDTO userDTO);
    void update(UserDTO userDTO);
    void deleteUser(Long id);
}
