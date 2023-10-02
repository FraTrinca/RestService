package com.nttdata.restservice.business.impl;

import com.nttdata.restservice.business.PlayerBO;
import com.nttdata.restservice.exception.RestRequestException;
import com.nttdata.restservice.model.Player;
import com.nttdata.restservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerBOImpl implements PlayerBO {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() { return playerRepository.findAll();}

    @Override
    public Player get(Long id) { return playerRepository.findById(id).orElseThrow(()-> new RestRequestException("Dipendente con id " + id + " non trovato", HttpStatus.NOT_FOUND));}

    @Override
    public Player insert(Player player) {
        playerRepository.save(player);
        return player;
    }

    @Override
    public void delete(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(()-> new RestRequestException("Dipendente con id " + id + " non trovato", HttpStatus.NOT_FOUND));
        playerRepository.delete(player);
    }
}
