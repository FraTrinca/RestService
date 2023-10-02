package com.nttdata.restservice.controller;

import com.nttdata.restservice.business.PlayerBO;
import com.nttdata.restservice.exception.RestRequestException;
import com.nttdata.restservice.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerBO playerBO;


    @GetMapping("/getPlayer/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
            Player player1 = playerBO.get(id);
            return new ResponseEntity<>(player1, HttpStatus.OK);
    }
    
    @GetMapping("/getTeam")
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(playerBO.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<Player> create(@RequestBody Player player){
        playerBO.insert(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        playerBO.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Player> update(@RequestBody Player player){
        Player player1 = playerBO.insert(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


}
