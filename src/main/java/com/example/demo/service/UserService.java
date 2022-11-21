package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.save(todo(userDTO));
        return todto(user);
    }

    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs=users.stream().map(
        user->modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return userDTOs;}

    public UserDTO update(UserDTO userDTO, Long id) {
         if (userPresentById(id)){
            User user = userRepository.save(todo(userDTO));
            return todto(user);  }
        else{throw new NullPointerException();   }}




    public Boolean userPresentById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return true;}
        else {
            throw new NullPointerException();}}

    public  UserDTO findUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return todto(user.get());
        } else {
            throw new NullPointerException();}}


    public User todo(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
    public UserDTO todto(User user){
        return modelMapper.map(user,UserDTO.class);
    }



}