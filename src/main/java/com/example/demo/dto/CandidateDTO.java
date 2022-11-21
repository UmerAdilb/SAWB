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
public class CandidateDTO {

    private Long id;
    @NotBlank
    @Size(min = 3)
    private String scientificName;
    @NotBlank
    @Size(min = 3)
    private String commonName;
    @NotBlank
    @Size(min = 15)
    private String description;
}
