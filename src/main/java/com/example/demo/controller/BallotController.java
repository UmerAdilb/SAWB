package com.example.demo.controller;

import com.example.demo.domain.Ballot;
import com.example.demo.dto.BallotDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.dto.TallyResponse;
import com.example.demo.service.BallotService;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("ballot/")
@CrossOrigin
public class BallotController {
    @Autowired
    BallotService ballotService;

    @PostMapping("/save")
    public ResponseEntity<BallotDTO> saveVote(@Valid @RequestBody BallotDTO balletDTO) {
        return ResponseEntity.ok(ballotService.addVote(balletDTO));}

    @DeleteMapping("/delete/{membershipNumber}")
    public String deleteVote(@Valid @PathVariable Long membershipNumber) {
        return ballotService.deleteVote(membershipNumber);}


    @GetMapping("/get/{membershipNumber}")
    public ResponseEntity<CandidateDTO> showCandidateVoted(@PathVariable Long membershipNumber){
        return ResponseEntity.ok(ballotService.getVotedCandidate(membershipNumber));
    }

    @GetMapping("/tally")
    public ResponseEntity<List<TallyResponse>> showAllVotesForCandidates(){
        return ResponseEntity.ok(ballotService.getVotesForCandidate());
    }


}
