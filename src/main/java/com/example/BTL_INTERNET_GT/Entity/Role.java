package com.example.BTL_INTERNET_GT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @PrePersist
    protected void onCreate(){
        this.created_At =  new Date(System.currentTimeMillis());
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_At =  new Date(System.currentTimeMillis());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date created_At;
    private Date updated_At;
    @ManyToMany(mappedBy = "roles")
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<User> users = new HashSet<>();
    public Role(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Role(String name){
        this.name = name;
    }
}
