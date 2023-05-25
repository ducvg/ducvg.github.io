package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepo repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void addUser(User u){
        System.out.println("UserService: adduser: "+u);
        repo.save(u);
    }

    public User getUserById(Long id){
        Optional<User> user = repo.findById(id);
        if(user.isPresent()) return user.get();
        else return null;
    }

    public void updateUser(User user){
        repo.save(user);
    }

    public void removeUserById(Long id){
        repo.deleteById(id);
    }
}

