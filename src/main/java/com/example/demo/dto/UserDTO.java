package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    private String role;
}
