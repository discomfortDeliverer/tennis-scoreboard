package ru.discomfortDeliverer.service;

import ru.discomfortDeliverer.dao.PlayerDao;
import ru.discomfortDeliverer.model.Player;

public class PlayerService {
    private PlayerDao playerDao = new PlayerDao();
    public void createPlayerIfNotExists(Player player){
        String validatedName = validatePlayerName(player.getName());
        player.setName(validatedName);
        playerDao.createPlayerIfNotExists(player);
    }

    private String validatePlayerName(String playerName){
        return playerName.trim();
    }

    public Player findPlayerById(Integer playerId) {
        return playerDao.findPlayerById(playerId);
    }
}
