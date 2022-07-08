package com.managementSystem.service;

import com.managementSystem.Response.SportResponse;
import com.managementSystem.entity.Sports;
import com.managementSystem.repository.SportsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    @Autowired
    SportsRepo sportsRepo;
    public List<Sports> getAll() {
        return sportsRepo.findAll();
    }

    public Sports getSportsByName(String sportsName) {
        return sportsRepo.getSportByName(sportsName);
    }
}
