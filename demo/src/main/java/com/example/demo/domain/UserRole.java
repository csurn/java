package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class UserRole extends BaseEntity {
    @Column(name = "userId", updatable = false, insertable = false)
    private String userId;
    @Column(name = "roleId", updatable = false, insertable = false)
    private String roleId;
    @JoinColumn(name = "userId")
    @ManyToOne(targetEntity = User.class)
    private User user;
    @JoinColumn(name = "roleId")
    @ManyToOne(targetEntity = Role.class)
    private Role role;
}
