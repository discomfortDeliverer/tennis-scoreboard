package ru.discomfortDeliverer.dto;

import ru.discomfortDeliverer.model.Player;
import ru.discomfortDeliverer.model.Score;

import java.util.Objects;
import java.util.UUID;

public class MatchDTO {
    private UUID uuid;
    private Player firstPlayer;
    private Player secondPlayer;
    private Score currentScore;
    private boolean finished;

    public MatchDTO() {
        this.uuid = UUID.randomUUID();
        this.currentScore = new Score();
        this.finished = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDTO matchDTO = (MatchDTO) o;
        return finished == matchDTO.finished && Objects.equals(uuid, matchDTO.uuid) && Objects.equals(firstPlayer, matchDTO.firstPlayer) && Objects.equals(secondPlayer, matchDTO.secondPlayer) && Objects.equals(currentScore, matchDTO.currentScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, firstPlayer, secondPlayer, currentScore, finished);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Score getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Score currentScore) {
        this.currentScore = currentScore;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
