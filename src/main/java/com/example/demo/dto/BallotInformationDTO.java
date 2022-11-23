package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BallotInformationDTO {
    private Long id;
    private Boolean pollingEnabled ;
}
