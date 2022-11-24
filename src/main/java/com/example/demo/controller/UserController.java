package com.example.demo.controller;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.LoginCredentials;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.JwtUtil;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")


public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailService myUserDetailService;
    @Autowired
    JwtUtil jwtUtill;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));}

    @GetMapping("/get")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getAllUser());}

    @PutMapping("update/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Long id) {
        return ResponseEntity.ok(userService.update(userDTO,id));}


    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> generateToken(@RequestBody LoginCredentials loginCredentials){
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginCredentials.getUsername(),loginCredentials.getPassword()));

        UserDetails userDetails=myUserDetailService.loadUserByUsername(loginCredentials.getUsername());
        String jwtToken=jwtUtill.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

}
