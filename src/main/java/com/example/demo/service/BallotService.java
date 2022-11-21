package com.example.demo.service;

import com.example.demo.domain.Ballot;
import com.example.demo.domain.User;
import com.example.demo.dto.BallotDTO;
import com.example.demo.repository.BallotRepository;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BallotService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;
    @Autowired
    BallotRepository ballotRepository;
    public BallotDTO addVote(BallotDTO ballotDTO) {
        if (userIsPresent(ballotDTO.getUser().getMembershipNumber())){
            Optional<User> user = userRepository.findByMembershipNumber(ballotDTO.getUser().getMembershipNumber());
            Ballot ballot = ballotRepository.findByUserId(user.get().getId());
            ballot.setCandidate(ballotDTO.getCandidate());
            Ballot updatedBallot = ballotRepository.save(ballot);
            return todto(updatedBallot);
        }else {
            User user = userRepository.save(ballotDTO.getUser());
            Ballot ballot = todo(ballotDTO);
            ballot.setUser(user);
            Ballot savedBallot =ballotRepository.save(ballot);
            return todto(savedBallot);    }

    }

    private Boolean userIsPresent(Long membershipNumber) {
        Optional<User> user = userRepository.findByMembershipNumber(membershipNumber);
        if (user.isPresent()){
            return true;
        }else{
            return false;
        }
    }


    public Ballot todo(BallotDTO ballotDTO){return modelMapper.map(ballotDTO,Ballot.class);}
    public BallotDTO todto(Ballot ballot){return modelMapper.map(ballot,BallotDTO.class);
    }

    public String deleteVote(Long membershipNumber) {
       if (userIsPresent(membershipNumber)){
           Optional<User> user = userRepository.findByMembershipNumber(membershipNumber);
           ballotRepository.deleteByUserId(user.get().getId());
           return ("Deleted Succesfully");
       }
        return ("Error while deleting!");
    }
}
