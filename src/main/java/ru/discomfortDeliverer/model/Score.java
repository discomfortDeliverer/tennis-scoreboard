package ru.discomfortDeliverer.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private Integer firstPlayerPoint; // 0, 15, 30, 40, win
    private boolean firstPlayerAd;
    private Integer secondPlayerPoint;
    private boolean secondPlayerAd;
    private Integer firstPlayerGame; // 0, 1, 2, 3, 4, 5, 6
    private Integer secondPlayerGame;
    private Integer firstPlayerSet; // Bo3
    private Integer secondPlayerSet;
    private List<int[]> setResults;

    public Score() {
        this.firstPlayerPoint = 0;
        this.firstPlayerAd = false;
        this.secondPlayerPoint = 0;
        this.secondPlayerAd = false;
        this.firstPlayerGame = 0;
        this.secondPlayerGame = 0;
        this.firstPlayerSet = 0;
        this.secondPlayerSet = 0;
        this.setResults = new ArrayList<>();
    }

    public List<int[]> getSetResults() {
        return setResults;
    }

    public void setSetResults(List<int[]> setResults) {
        this.setResults = setResults;
    }

    public Integer getFirstPlayerPoint() {
        return firstPlayerPoint;
    }

    public void setFirstPlayerPoint(Integer firstPlayerPoint) {
        this.firstPlayerPoint = firstPlayerPoint;
    }

    public boolean isFirstPlayerAd() {
        return firstPlayerAd;
    }

    public void setFirstPlayerAd(boolean firstPlayerAd) {
        this.firstPlayerAd = firstPlayerAd;
    }

    public Integer getSecondPlayerPoint() {
        return secondPlayerPoint;
    }

    public void setSecondPlayerPoint(Integer secondPlayerPoint) {
        this.secondPlayerPoint = secondPlayerPoint;
    }

    public boolean isSecondPlayerAd() {
        return secondPlayerAd;
    }

    public void setSecondPlayerAd(boolean secondPlayerAd) {
        this.secondPlayerAd = secondPlayerAd;
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
