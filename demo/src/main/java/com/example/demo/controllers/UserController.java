package com.example.demo.controllers;

import com.example.demo.domain.*;
import io.ebean.BeanState;
import io.ebean.DB;
import io.ebean.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/users")
    public List<User> users() {
        String name = DB.byName("sqlite").getName();
        User user = new User();
        user.setUserName("admin");
        Role role = new Role();
        role.setName("Radmin");
        Permission permission = new Permission();
        permission.setName("Padmin");

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        user.getUserRoles().add(userRole);

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permission.getId());
        role.getRolePermissions().add(rolePermission);

        DB.getDefault().save(user);
        List<User> list = DB.getDefault().createQuery(User.class).findList();
        return list;
    }

    @Transactional
    @RequestMapping("/add")
    public User add(User user) {
        BeanState state = DB.getDefault().getBeanState(user);
        if (state.isNew()) {
            DB.getDefault().save(user);
        }
        return user;
    }

    @Transactional
    @RequestMapping("/edit")
    public User edit(User user) {
        BeanState state = DB.getDefault().getBeanState(user);
        if (state.isDirty()) {
            DB.getDefault().save(user);
        }
        return user;
    }

    @Transactional
    @RequestMapping("/delete")
    public User delete(String id) {
        User user = DB.getDefault().find(User.class, id);
        if (user != null) {
            DB.getDefault().delete(user);
        }
        return user;
    }
}
