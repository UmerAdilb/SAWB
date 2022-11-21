package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Ballot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
