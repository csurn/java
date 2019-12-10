package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.domain.User;
import io.ebean.BeanState;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

import io.ebean.DB;
import io.ebean.Database;

@RestController
public class HomeController {


    @RequestMapping("/")
    public List<User> index() {
        List<User> list = DB.getDefault().createQuery(User.class).fetch("userRoles").where().isNotNull("userName").findList();
        return list;
    }

    @RequestMapping("/add")
    public User add(User user) {
        BeanState state = DB.getDefault().getBeanState(user);
        if (state.isNew()) {
            DB.getDefault().save(user);
        }
        return user;
    }
    @RequestMapping("/edit")
    public User edit(User user) {
        BeanState state = DB.getDefault().getBeanState(user);
        if (state.isDirty()) {
            DB.getDefault().save(user);
        }
        return user;
    }
}
