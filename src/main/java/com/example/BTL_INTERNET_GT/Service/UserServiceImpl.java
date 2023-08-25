package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.UserDTO;
import com.example.BTL_INTERNET_GT.Entity.Role;
import com.example.BTL_INTERNET_GT.Entity.User;
import com.example.BTL_INTERNET_GT.Repo.RoleRepo;
import com.example.BTL_INTERNET_GT.Repo.UserRepo;
import com.example.BTL_INTERNET_GT.SecurityConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepository;

    @Autowired
    SecurityConfiguration configuration;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public void addToUser(String username, String rolename) {
        if(!userRepo.findByEmail(username).isPresent()){
            throw  new IllegalArgumentException("User with email" + username  + "does not exits");
        }
        Role role = roleRepository.findByName(rolename);
        if(role == null){
            throw  new IllegalArgumentException("Role with email" + username  + "does not exits");
        }
        User user = userRepo.findByEmail(username).get();
        user.getRoles().add(role);
    }
    @Override
    public void singup(UserDTO userDTO){
        User user = new User();
        user.setFullName(userDTO.getUser_name());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhoneNumber(userDTO.getMobile_number());
        user.setEmail(userDTO.getEmail());
        userRepo.save(user);

    }
    public void update(UserDTO userDTO){
        User user = userRepo.findByEmail(userDTO.getEmail()).orElseThrow(() -> new RuntimeException("Uuser Ivalid"));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(userDTO.getRoles());
        userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
