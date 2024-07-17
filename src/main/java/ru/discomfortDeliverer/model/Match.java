package ru.discomfortDeliverer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Player1")
    private Player firstPlayer;
    @ManyToOne
    @JoinColumn(name = "Player2")
    private Player secondPlayer;
    @ManyToOne
    @JoinColumn(name = "Winner")
    private Player winner;

    @Override
    public String toString() {
        return "MatchEntity{" +
                "id=" + id +
                ", firstPlayer=" + firstPlayer.getName() +
                ", secondPlayer=" + secondPlayer.getName() +
                ", winner=" + winner.getName() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
