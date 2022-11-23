package com.example.demo.controller;

import com.example.demo.domain.BallotInformation;
import com.example.demo.dto.BallotInformationDTO;
import com.example.demo.service.BallotInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class BallotInformationController {
    @Autowired
    BallotInformationService balletInformationService;
    @PutMapping("polling")
    public ResponseEntity<BallotInformationDTO> pollingEnabling(@RequestBody BallotInformationDTO ballotInformationDTO){
        return ResponseEntity.ok(balletInformationService.updatePolling(ballotInformationDTO));
    }


}
