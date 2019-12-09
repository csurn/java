package com.example.demo.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Permission extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "permission",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RolePermission> rolePermissions = new ArrayList<>();
}
