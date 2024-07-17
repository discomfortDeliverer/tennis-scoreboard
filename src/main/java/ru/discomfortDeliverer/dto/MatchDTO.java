package ru.discomfortDeliverer.dto;

import ru.discomfortDeliverer.model.Score;

import java.util.Objects;
import java.util.UUID;

public class MatchDTO {
    private UUID uuid;
    private Integer firstPlayerId;
    private Integer secondPlayerId;
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
        return Objects.equals(uuid, matchDTO.uuid) && Objects.equals(firstPlayerId, matchDTO.firstPlayerId) && Objects.equals(secondPlayerId, matchDTO.secondPlayerId) && Objects.equals(currentScore, matchDTO.currentScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, firstPlayerId, secondPlayerId, currentScore);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setFirstPlayerId(Integer firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public void setSecondPlayerId(Integer secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public void setCurrentScore(Score currentScore) {
        this.currentScore = currentScore;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Integer getFirstPlayerId() {
        return firstPlayerId;
    }

    public Integer getSecondPlayerId() {
        return secondPlayerId;
    }

    public Score getCurrentScore() {
        return currentScore;
    }
}
