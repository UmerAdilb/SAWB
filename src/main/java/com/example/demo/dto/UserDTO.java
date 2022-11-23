package com.example.demo.dto;

import com.example.demo.domain.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 18)
    private Integer age;
    private Long membershipNumber;
    @NotBlank
    @Size(min = 3)
    private String region;

    @JsonIgnore
    private Set<Roles> roles = new HashSet<Roles>();
}
