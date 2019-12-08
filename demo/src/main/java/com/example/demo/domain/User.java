package com.example.demo.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User extends BaseEntity {
    private String userName;
    private String Password;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserRole> userRole = new ArrayList<>();
}
