package com.example.demo.dto;

import com.example.demo.domain.Candidate;
import com.example.demo.domain.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BallotDTO {
    private Long id;
    private User user;
    private Candidate candidate;

}
