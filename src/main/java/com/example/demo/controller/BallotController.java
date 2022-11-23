package com.example.demo.controller;

import com.example.demo.domain.Ballot;
import com.example.demo.dto.BallotDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.service.BallotService;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class    BallotController {
    @Autowired
    BallotService ballotService;

    /**
     * This will post ballot
     * @param balletDTO
     * @return
     */

    @PostMapping("/ballot")
    public ResponseEntity<BallotDTO> saveVote(@Valid @RequestBody BallotDTO balletDTO) {
        return ResponseEntity.ok(ballotService.addVote(balletDTO));}

    /**
     * This will delete ballot by member ship number
     * @param membershipNumber
     * @return
     */
    @DeleteMapping("/ballot/{membershipNumber}")
    public String deleteVoteByMemberShipNumber(@Valid @PathVariable Long membershipNumber) {
        return ballotService.deleteVote(membershipNumber);}


    /**
     * This will get vote og particular user
     * @param membershipNumber
     * @return
     */
    @GetMapping("/ballot/{membershipNumber}")
    public ResponseEntity<CandidateDTO> showCandidateVoted(@PathVariable Long membershipNumber){
        return ResponseEntity.ok(ballotService.getVotedCandidate(membershipNumber));
    }


}
