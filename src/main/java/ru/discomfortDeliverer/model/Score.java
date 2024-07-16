package ru.discomfortDeliverer.model;

public class Score {
    private Integer firstPlayerPoint; // 0, 15, 30, 45, 60
    private Integer secondPlayerPoint;
    private Integer firstPlayerGame; // 0, 1, 2, 3, 4, 5, 6
    private Integer secondPlayerGame;
    private Integer firstPlayerSet; // Bo3
    private Integer secondPlayerSet;

    public Score() {
        this.firstPlayerPoint = 0;
        this.secondPlayerPoint = 0;
        this.firstPlayerGame = 0;
        this.secondPlayerGame = 0;
        this.firstPlayerSet = 0;
        this.secondPlayerSet = 0;
    }

    public Integer getFirstPlayerPoint() {
        return firstPlayerPoint;
    }

    public void setFirstPlayerPoint(Integer firstPlayerPoint) {
        this.firstPlayerPoint = firstPlayerPoint;
    }

    public Integer getSecondPlayerPoint() {
        return secondPlayerPoint;
    }

    public void setSecondPlayerPoint(Integer secondPlayerPoint) {
        this.secondPlayerPoint = secondPlayerPoint;
    }

    public Integer getFirstPlayerGame() {
        return firstPlayerGame;
    }

    public void setFirstPlayerGame(Integer firstPlayerGame) {
        this.firstPlayerGame = firstPlayerGame;
    }

    public Integer getSecondPlayerGame() {
        return secondPlayerGame;
    }

    public void setSecondPlayerGame(Integer secondPlayerGame) {
        this.secondPlayerGame = secondPlayerGame;
    }

    public Integer getFirstPlayerSet() {
        return firstPlayerSet;
    }

    public void setFirstPlayerSet(Integer firstPlayerSet) {
        this.firstPlayerSet = firstPlayerSet;
    }

    public Integer getSecondPlayerSet() {
        return secondPlayerSet;
    }

    public void setSecondPlayerSet(Integer secondPlayerSet) {
        this.secondPlayerSet = secondPlayerSet;
    }
}
