package com.nttdata.restservice.business;

import com.nttdata.restservice.model.Player;

import java.util.List;

public interface PlayerBO {

    List<Player> getAll();

    public Player get(Long id);

    Player insert(Player player);

    void delete(Long id);
}
