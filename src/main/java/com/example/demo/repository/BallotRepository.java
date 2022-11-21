package com.example.demo.repository;

import com.example.demo.domain.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BallotRepository extends JpaRepository<Ballot,Long> {
    Optional<Ballot> findByUserId(Long id);

    void deleteByUserId(Long id);
}
