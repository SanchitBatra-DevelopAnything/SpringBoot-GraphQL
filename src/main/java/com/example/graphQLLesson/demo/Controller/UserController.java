package com.example.graphQLLesson.demo.Controller;

import com.example.graphQLLesson.demo.Entities.User;
import com.example.graphQLLesson.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone , @Argument String email , @Argument String password)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPasssword(password);
        user.setPhone(phone);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userId)
    {
        return userService.getUser(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId)
    {
        return userService.deleteUser(userId);
    }
}
