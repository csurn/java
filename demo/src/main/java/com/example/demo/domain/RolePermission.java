package com.example.demo.domain;

import javax.persistence.*;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"roleId","permissionId"})})
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
