package com.example.demo.controller;

import com.example.demo.dto.CandidateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("candidate/")
@CrossOrigin
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @PostMapping("/save")
    public ResponseEntity<CandidateDTO> saveUser(@Valid @RequestBody CandidateDTO candidateDTO) {
        return ResponseEntity.ok(candidateService.addUser(candidateDTO));}

    @GetMapping("/get")
    public ResponseEntity<List<CandidateDTO>> getUsers(){
        return ResponseEntity.ok(candidateService.getAllUser());}

    @PutMapping("update/{id}")
    public ResponseEntity<CandidateDTO> updateUser(@Valid @RequestBody CandidateDTO candidateDTO,@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.update(candidateDTO,id));}
}
