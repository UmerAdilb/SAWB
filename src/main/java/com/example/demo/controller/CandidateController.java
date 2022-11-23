package com.example.demo.controller;

import com.example.demo.dto.CandidateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class CandidateController {
    @Autowired
    CandidateService candidateService;

    /**
     * This will post candidate
     * @param candidateDTO
     * @return
     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/candidate")
    public ResponseEntity<CandidateDTO> saveCandidate(@Valid @RequestBody CandidateDTO candidateDTO) {
        return ResponseEntity.ok(candidateService.addCandidate(candidateDTO));}

    /**
     * This will get candidte
     * @return
     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/candidate")
    public ResponseEntity<List<CandidateDTO>> getAllCandidate(){
        return ResponseEntity.ok(candidateService.getAllCandidate());}

    /**
     * This will update candidate by id
     * @param candidateDTO
     * @param id
     * @return
     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/candidate/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@Valid @RequestBody CandidateDTO candidateDTO,@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.updateCandidateById(candidateDTO,id));}
}
