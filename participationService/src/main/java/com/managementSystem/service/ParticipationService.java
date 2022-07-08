package com.managementSystem.service;

import com.managementSystem.entity.Participation;
import com.managementSystem.repository.ParticipationRepo;
import com.managementSystem.request.CreateParticipation;
import com.managementSystem.response.ParticipationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepo participationRepo;

    public Participation addParticipation(CreateParticipation createParticipation) {
        return participationRepo.save(new Participation(createParticipation));
    }

    public List<Participation> getAllParticipation() {
        return participationRepo.findAll();
    }

    public ResponseEntity<Participation> updateStatus(Long participationId, ParticipationResponse participationResponse) {

            if(participationRepo.findById(participationId).isPresent()) {


                Participation participation = participationRepo.findById(participationId).get();

                participation.setStatus(participationResponse.getStatus());
                final Participation updatedParticipation = participationRepo.save(participation);
                return ResponseEntity.ok(updatedParticipation);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Participation>> getParticipationStatus(String status) {
        List<Participation> list =participationRepo.findByStatus(status);
        if(list.size()>0){
            return ResponseEntity.ok(list);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
