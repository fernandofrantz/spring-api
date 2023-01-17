package com.springboot.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.api.services.UserService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.springboot.api.models.User;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping( "users" )
public class UserController {

    @Autowired
    private final UserService userService;
    private Gson gson =  new Gson();

    public UserController( UserService userService ) {
        this.userService = userService;
    }    

    @GetMapping
    public ResponseEntity<String> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<String>( gson.toJson( users ), HttpStatus.OK );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<String> getUserById( @PathVariable( value="id" ) Long id ) {

        User user = userService.getUserById( id );

        return new ResponseEntity<>( gson.toJson( user ), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<String> createUser( @RequestBody User user ) {

        Date creationTime = new Date( System.currentTimeMillis() );

        System.out.println( creationTime );

        user.setCreated_at( creationTime );
        user.setUpdated_at( creationTime );

        userService.addUser( user );
        
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<String> updateUser( @PathVariable long id, @RequestBody User user ) {

        Date creationTime = new Date( System.currentTimeMillis() );

        user.setUpdated_at( creationTime );
        
        userService.updateUser( id, user );
        
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
