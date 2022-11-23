package com.example.demo.service;

import com.example.demo.domain.Candidate;

import com.example.demo.dto.CandidateDTO;

import com.example.demo.repository.CandidateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    ModelMapper modelMapper;

    public CandidateDTO addCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = candidateRepository.save(todo(candidateDTO));
        return todto(candidate);
    }

    public List<CandidateDTO> getAllCandidate() {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDTO> candidateDTOS=candidates.stream().map(
                c->modelMapper.map(c,CandidateDTO.class)).collect(Collectors.toList());
        return candidateDTOS;}

    public CandidateDTO updateCandidateById(CandidateDTO candidateDTO, Long id) {
        if (candidatePresentById(id)){
            Candidate candidate = candidateRepository.save(todo(candidateDTO));
            return todto(candidate);  }
        else{throw new NullPointerException();   }}




    public Boolean candidatePresentById(Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()){
            return true;}
        else {
            throw new NullPointerException();}}

    public  CandidateDTO findCandidateById(long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return todto(candidate.get());
        } else {
            throw new NullPointerException();}}


    public Candidate todo(CandidateDTO candidateDTO){
        return modelMapper.map(candidateDTO,Candidate.class);
    }
    public CandidateDTO todto(Candidate candidate){return modelMapper.map(candidate,CandidateDTO.class);
    }

}
