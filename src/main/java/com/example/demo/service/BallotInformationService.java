package com.example.demo.service;

import com.example.demo.domain.BallotInformation;
import com.example.demo.domain.Candidate;
import com.example.demo.dto.BallotInformationDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.repository.BallotInformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BallotInformationService {
    @Autowired
    BallotInformationRepository ballotInformationRepository;

    @Autowired
    ModelMapper modelMapper;

    public BallotInformationDTO updatePolling(BallotInformationDTO ballotInformationDTO) {
    Optional<BallotInformation> ballotInformation= ballotInformationRepository.findById(1L);
    ballotInformation.get().setPollingEnabled(ballotInformationDTO.getPollingEnabled());
    BallotInformation saved = ballotInformationRepository.save(ballotInformation.get());
    return todto(saved);}

    public BallotInformation todo(BallotInformationDTO ballotInformationDTO){
        return modelMapper.map(ballotInformationDTO,BallotInformation.class);
    }
    public BallotInformationDTO todto(BallotInformation ballotInformation){return modelMapper.map(ballotInformation,BallotInformationDTO.class);
    }
}
