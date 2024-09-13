package com.example.graphQLLesson.demo.Services;

import com.example.graphQLLesson.demo.Entities.User;
import com.example.graphQLLesson.demo.Helper.ExceptionHandler;
import com.example.graphQLLesson.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user)
    {
        return userRepo.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    public User getUser(int userId)
    {
        return userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    public boolean deleteUser(int userId)
    {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }

    //update user is TODO.
}
