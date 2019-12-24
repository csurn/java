package demo.controllers;

import demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UserController {
    UserRepository userRepository;
    public UserController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @RequestMapping("/users")
    public Iterable<User> users(@RequestParam(defaultValue = "0")int page,
                                @RequestParam(defaultValue = "10") int size) {

        var jpql = "from User as u";
        jpql+=" inner join fetch u.userRoles as ur";
        jpql+=" inner join fetch ur.role as r";
        jpql+=" inner join fetch r.rolePermissions as rp";
        jpql+=" inner join fetch rp.permission";
        Iterable<User> list = this.userRepository.search(jpql,page,size);
        return list;
    }

    @Transactional
    @RequestMapping("/add")
    public User add(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Transactional
    @RequestMapping("/edit")
    public User edit(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Transactional
    @RequestMapping("/delete")
    public User delete(String id) {
        User user = this.userRepository.findById(id).get();
        this.userRepository.delete(user);
        return user;
    }
}
