package com.example.demo.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private String userName;
    private String password;
    public User(String userName,String password)
    {
       this.userName=userName;
       this.password=password;
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();
}
