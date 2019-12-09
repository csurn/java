package com.example.demo.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Role extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserRole> userRole = new ArrayList<>();
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RolePermission> rolePermissions = new ArrayList<>();
}
