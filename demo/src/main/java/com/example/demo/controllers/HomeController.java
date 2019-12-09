package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.domain.User;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@RestController
public class HomeController {
    @Autowired
    private EbeanServer server;

    @RequestMapping("/")
    public String greeting() {

        return new User("","").getUserName();//server.find(User.class).where().isNotNull("userName").findList();
    }

    @RequestMapping("/add")
    public User greeting(String userName,String password) {
        User user = new User(userName,password);
        server.save(user);
        return user;
    }
}
