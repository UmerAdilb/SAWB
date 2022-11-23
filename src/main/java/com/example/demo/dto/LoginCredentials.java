package com.example.demo.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginCredentials {


    private String username;
    private String password;

}
