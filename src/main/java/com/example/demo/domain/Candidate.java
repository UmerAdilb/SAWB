package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String scientificName;
    private String commonName;
    private String description;
    @OneToMany(mappedBy = "candidate",cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Ballot> ballots;

}
