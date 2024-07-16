package ru.discomfortDeliverer.service;

import ru.discomfortDeliverer.dao.PlayerDao;
import ru.discomfortDeliverer.model.Player;

public class PlayerService {
    private PlayerDao playerDao = new PlayerDao();
    public void createPlayerIfNotExists(Player player){
        playerDao.createPlayerIfNotExists(player);
    }

    public Player findPlayerById(Integer playerId) {
        return playerDao.findPlayerById(playerId);
    }
}
