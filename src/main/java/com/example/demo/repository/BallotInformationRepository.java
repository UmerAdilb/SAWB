package com.example.demo.repository;

import com.example.demo.domain.BallotInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallotInformationRepository extends JpaRepository<BallotInformation,Long> {
}
