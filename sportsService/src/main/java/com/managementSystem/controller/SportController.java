package com.managementSystem.controller;

import com.managementSystem.Response.SportResponse;
import com.managementSystem.entity.Event;
import com.managementSystem.entity.Sports;
import com.managementSystem.exception.ResourceNotFoundException;
import com.managementSystem.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportService service;

    @GetMapping("/sports")
    public ResponseEntity<List<Sports>> getAllSportsDetail(){
        List<Sports> list =service.getAll();
        if(list.size()<=0){
            throw new ResourceNotFoundException("Empty");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getSportsByName/{name}")
    public ResponseEntity<Sports> getSportsByName(@PathVariable("name") String sportsName){
        Sports sport = service.getSportsByName(sportsName);
        if(sport==null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(sport);
    }
}
