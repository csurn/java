package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class RolePermission extends BaseEntity {
    @Column(name = "roleId", updatable = false, insertable = false)
    private String roleId;
    @Column(name = "permissionId", updatable = false, insertable = false)
    private String permissionId;
    @JoinColumn(name = "roleId")
    @ManyToOne(targetEntity = Role.class)
    private Role role;
    @JoinColumn(name = "permissionId")
    @ManyToOne(targetEntity = Permission.class)
    private Permission permission;
}
