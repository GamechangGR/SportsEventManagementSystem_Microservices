package com.managementSystem.controller;

import com.managementSystem.entity.Participation;
import com.managementSystem.request.CreateParticipation;
import com.managementSystem.response.ParticipationResponse;
import com.managementSystem.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participation")
public class ParticipationController {

    @Autowired
    private ParticipationService service;

    @PostMapping("/addparticipation")
    public ParticipationResponse addParticipation(@RequestBody CreateParticipation createParticipation){
        Participation participation =service.addParticipation(createParticipation);
        return new ParticipationResponse(participation);
    }

    @GetMapping("/getParticipations")
    public ResponseEntity<List<Participation>> getAllParticipation(){
        List<Participation> list =service.getAllParticipation();
        if(list.size()>0){
            return ResponseEntity.ok(list);
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Participation> updateStatus(@PathVariable(value = "id")Long participationId,@RequestBody ParticipationResponse participationResponse){
       return service.updateStatus(participationId,participationResponse);

    }

    @GetMapping("/getApprovedParticipations/{approved}")
    public List<Participation> getApprovedParticipations(@PathVariable("approved")String approvedStatus){
        return  service.getParticipationStatus(approvedStatus);
    }

    @GetMapping("/getDeclinedParticipations/{declined}")
    public  List<Participation> getDeclinedParticipations(@PathVariable("declined")String declinedStatus){
        return  service.getParticipationStatus(declinedStatus);
    }

    @GetMapping("/getPendingParticipations/{pending}")
    public  List<Participation> getPendingParticipations(@PathVariable("pending")String pendingStatus){
        return  service.getParticipationStatus(pendingStatus);
    }
}
