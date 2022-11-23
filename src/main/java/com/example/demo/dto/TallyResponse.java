package com.example.demo.dto;

import com.example.demo.domain.Candidate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TallyResponse {

    private Candidate candidate;
    private Long tally;
}
