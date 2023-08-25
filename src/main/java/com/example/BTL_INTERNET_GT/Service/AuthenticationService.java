package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.Auth.AuthenticationRequest;
import com.example.BTL_INTERNET_GT.Auth.AuthenticationResponse;
import com.example.BTL_INTERNET_GT.Entity.Role;
import com.example.BTL_INTERNET_GT.Entity.User;
import com.example.BTL_INTERNET_GT.Repo.RoleCustomRepo;
import com.example.BTL_INTERNET_GT.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleCustomRepo roleCustomRepo;
    private final UserService userService;

    public ResponseEntity<?> authenticate(AuthenticationRequest authenticationRequest){
        try{
            User user = userRepo.findByEmail(authenticationRequest.getEmail()).orElseThrow(() -> new NoSuchElementException("User not found"));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
            List<Role> role = null;
            if(user != null){
                role = roleCustomRepo.getRole(user);
            }
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Set<Role> set = new HashSet<>();
            role.stream().forEach(c -> {
                set.add(new Role((c.getName())));
                authorities.add(new SimpleGrantedAuthority(c.getName()));
            });
            user.setRoles(set);
            set.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority((i.getName()))));
            var jwtAccessToken = jwtService.generateToken(user,authorities);
            var jwtRefreshToken = jwtService.generateRefreshToken(user,authorities);

           return ResponseEntity.ok(AuthenticationResponse.builder().access_token(jwtAccessToken).refresh_token(jwtRefreshToken).email(user.getEmail()).user_name(user.getUsername()).build());
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BadCredentialsException e){
            return ResponseEntity.badRequest().body("Invalid Credential");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
