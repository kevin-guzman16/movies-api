package com.movies.movies.services;

import java.util.ArrayList;
import java.util.List;

import com.movies.movies.dao.UserRepository;
import com.movies.movies.dto.TUser;
import com.movies.movies.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<TUser> findAll() {
        List<User> users = this.userRepository.findAll();
        List<TUser> listUsers = new ArrayList<>();
        for(User u : users) {
            listUsers.add(u.toTransfer());
        }
        return listUsers;
    }
}
