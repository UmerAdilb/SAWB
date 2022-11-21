package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));}

    @GetMapping("/get")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getAllUser());}

    @PutMapping("update/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Long id) {
        return ResponseEntity.ok(userService.update(userDTO,id));}

}
