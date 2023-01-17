package com.springboot.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import com.springboot.api.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser( User user ) {
        userRepository.save( user );
    }

    public User getUserById( Long id ) {
        return userRepository.findById( id ).orElse( null );
    }

    public void updateUser( long id, User newUserInfos ) {
        User user = userRepository.findById( id ).orElse( null );

        user.setName( newUserInfos.getName() );
        user.setCpf( newUserInfos.getCpf() );

        userRepository.save( user );
    }
}
