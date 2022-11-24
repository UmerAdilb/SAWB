package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private Long membershipNumber;
    private String region;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles=new HashSet<>();
}
