package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.CustomUserDetail;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid Email ! No User Exist !");
        }
        return new CustomUserDetail(user);
    }
}
