package com.example.demo.service;

import com.example.demo.domain.Ballot;
import com.example.demo.domain.Candidate;
import com.example.demo.domain.User;
import com.example.demo.dto.BallotDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.exception.NoValueFound;
import com.example.demo.repository.BallotRepository;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BallotService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BallotRepository ballotRepository;
    @Autowired
    CandidateRepository candidateRepository;

    public BallotDTO addVote(BallotDTO ballotDTO) {
        if (userIsPresent(ballotDTO.getUser().getMembershipNumber())) {
            Optional<User> user = userRepository.findByMembershipNumber(ballotDTO.getUser().getMembershipNumber());
            Optional<Ballot> ballot = ballotRepository.findByUserId(user.get().getId());
            if (ballot.isPresent()){
                ballot.get().setUser(user.get());
                ballot.get().setCandidate(ballotDTO.getCandidate());
                Ballot updatedBallot = ballotRepository.save(ballot.get());
                return todto(updatedBallot);
            }else{
                ballotDTO.setUser(user.get());
                Ballot savedBallot = ballotRepository.save(todo(ballotDTO));
                return todto(savedBallot);
            }

        } else {
            User user = userRepository.save(ballotDTO.getUser());
            Ballot ballot = todo(ballotDTO);
            ballot.setUser(user);
            Ballot savedBallot = ballotRepository.save(ballot);
            return todto(savedBallot);
        }

    }

    private Boolean userIsPresent(Long membershipNumber) {
        Optional<User> user = userRepository.findByMembershipNumber(membershipNumber);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public String deleteVote(Long membershipNumber) {
        if (userIsPresent(membershipNumber)) {
            Optional<User> user = userRepository.findByMembershipNumber(membershipNumber);
            ballotRepository.deleteByUserId(user.get().getId());
            return ("Deleted Succesfully");
        }
        return ("Error while deleting!");
    }

    public CandidateDTO getVotedCandidate(Long membershipNumber) {
        if (userIsPresent(membershipNumber)) {
            Optional<User> user = userRepository.findByMembershipNumber(membershipNumber);
           Optional<Ballot>  ballot = ballotRepository.findByUserId(user.get().getId());
           if (ballot.isPresent()){
               Optional<Candidate> candidate = candidateRepository.findById(ballot.get().getCandidate().getId());
               return todto(candidate.get());}
        } throw new NoValueFound("No Value Exists!");
    }
    public CandidateDTO todto(Candidate candidate){return modelMapper.map(candidate,CandidateDTO.class);}
        public Ballot todo(BallotDTO ballotDTO) {
            return modelMapper.map(ballotDTO, Ballot.class);
        }

        public BallotDTO todto(Ballot ballot) {
            return modelMapper.map(ballot, BallotDTO.class);
        }
}