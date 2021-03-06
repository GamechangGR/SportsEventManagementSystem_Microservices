package com.managementSystem.service;

import com.managementSystem.exception.ResourseNotFoundException;
import com.managementSystem.request.CreatePlayer;
import com.managementSystem.entity.PlayerEntity;
import com.managementSystem.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


    public PlayerEntity save(CreatePlayer createPlayer) {
        return playerRepository.save(new PlayerEntity(createPlayer));
    }



    public String removePlayer(long playerId) {
        if(playerRepository.existsById(playerId)) {
            String playerName =playerRepository.findById(playerId).get().getPlayerName();
            playerRepository.deleteById(playerId);
            return "Player "+playerName +" removed successfully.";
        }
        else{
            throw new ResourseNotFoundException("Player with ID:" + playerId + " does not exist, hence can't remove");
        }
    }

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerEntity getPlayerById(Long playerId) {
        if (playerRepository.findById(playerId).isPresent()) {
            return playerRepository.findById(playerId).get();
        }
        return null;
    }
}
