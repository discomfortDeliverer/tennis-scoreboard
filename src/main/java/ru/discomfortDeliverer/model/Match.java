package ru.discomfortDeliverer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Match {
    private UUID uuid;
    private Integer firstPlayerId;
    private Integer secondPlayerId;
    private Score currentScore;
    private boolean finished;

    public Match() {
        this.uuid = UUID.randomUUID();
        this.currentScore = new Score();
        this.finished = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(uuid, match.uuid) && Objects.equals(firstPlayerId, match.firstPlayerId) && Objects.equals(secondPlayerId, match.secondPlayerId) && Objects.equals(currentScore, match.currentScore);
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
