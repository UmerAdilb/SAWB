package com.example.demo.repository;

import com.example.demo.domain.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallotRepository extends JpaRepository<Ballot,Long> {
    Ballot findByUserId(Long id);

    void deleteByUserId(Long id);
}
