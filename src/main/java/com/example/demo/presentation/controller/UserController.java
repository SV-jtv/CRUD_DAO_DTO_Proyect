package com.example.demo.presentation.controller;

import com.example.demo.presentation.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    //FindAll
    @GetMapping("/find")
    public ResponseEntity<List<UserDTO>> findAll(){
        return null;
    }

    //Find by id
    @GetMapping("/find/{id}")
    public ResponseEntity<List<UserDTO>> findById(@PathVariable Long id){
        return null;
    }

    //Create user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO UserDTO){
        return null;
    }

    //Update user
    @PostMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO UserDTO, @PathVariable Long id){
        return null;
    }

    //Delete User
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return null;
    }

}
