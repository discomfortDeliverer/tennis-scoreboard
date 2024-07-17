package ru.discomfortDeliverer.service;

import ru.discomfortDeliverer.dao.MatchDao;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.MatchEntity;
import ru.discomfortDeliverer.model.Player;
import ru.discomfortDeliverer.model.Score;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MatchService {
    private MatchDao matchDao = new MatchDao();
    public void updateMatchScore(Match currentMatch, Integer playerWinPointId) {
        Score currentScore = currentMatch.getCurrentScore();
        Integer firstPlayerId = currentMatch.getFirstPlayerId();
        Integer secondPlayerId = currentMatch.getSecondPlayerId();
        // Добавить логику обновления счета

        if(firstPlayerId == playerWinPointId){
            updateFirstPlayerPoints(currentScore);
            updateFirstPlayerGames(currentScore);
            updateFirstPlayerSets(currentScore, currentMatch);
        }
        if (secondPlayerId == playerWinPointId) {
            updateSecondPlayerPoints(currentScore);
            updateSecondPlayerGames(currentScore);
            updateSecondPlayerSets(currentScore, currentMatch);
        }
    }

    private void updateFirstPlayerPoints(Score currentScore){
        Integer firstPlayerPoint = currentScore.getFirstPlayerPoint();
        Integer secondPlayerPoint = currentScore.getSecondPlayerPoint();

        if(firstPlayerPoint < 30) {
            firstPlayerPoint += 15;
        } else if (firstPlayerPoint == 30) {
            firstPlayerPoint += 10;
        } else if(firstPlayerPoint == 40 && secondPlayerPoint < 40) {
            firstPlayerPoint = 0;
            Integer firstPlayerGame = currentScore.getFirstPlayerGame();
            firstPlayerGame++;
            currentScore.setFirstPlayerGame(firstPlayerGame);
            secondPlayerPoint = 0;
        } else if(firstPlayerPoint == 40 && secondPlayerPoint == 40 && currentScore.isFirstPlayerAd()){
            currentScore.setFirstPlayerAd(false);
            firstPlayerPoint = 0;
            Integer firstPlayerGame = currentScore.getFirstPlayerGame();
            firstPlayerGame++;
            currentScore.setFirstPlayerGame(firstPlayerGame);
            secondPlayerPoint = 0;
        } else if(firstPlayerPoint == 40 && secondPlayerPoint == 40 && currentScore.isSecondPlayerAd()){
            currentScore.setSecondPlayerAd(false);
        } else if(firstPlayerPoint == 40 && secondPlayerPoint == 40){
            currentScore.setFirstPlayerAd(true);
            return;
        }
        currentScore.setFirstPlayerPoint(firstPlayerPoint);
        currentScore.setSecondPlayerPoint(secondPlayerPoint);
    }

    private void updateFirstPlayerGames(Score currentScore) {
        Integer firstPlayerGame = currentScore.getFirstPlayerGame();
        Integer secondPlayerGame = currentScore.getSecondPlayerGame();
        List<int[]> setResults = currentScore.getSetResults();

        if(firstPlayerGame < 6 && secondPlayerGame < 6){
            return;
        }
        if(firstPlayerGame == 6 && secondPlayerGame < 5){
            setResults.add(new int[]{firstPlayerGame, secondPlayerGame});
            currentScore.setFirstPlayerGame(0);
            currentScore.setSecondPlayerGame(0);
            Integer firstPlayerSet = currentScore.getFirstPlayerSet();
            firstPlayerSet++;
            currentScore.setFirstPlayerSet(firstPlayerSet);
        } else {
            if((firstPlayerGame - secondPlayerGame) == 2){
                setResults.add(new int[]{firstPlayerGame, secondPlayerGame});
                currentScore.setFirstPlayerGame(0);
                currentScore.setSecondPlayerGame(0);
                Integer firstPlayerSet = currentScore.getFirstPlayerSet();
                firstPlayerSet++;
                currentScore.setFirstPlayerSet(firstPlayerSet);
            }
        }
    }

    private void updateFirstPlayerSets(Score currentScore, Match match){
        Integer firstPlayerSet = currentScore.getFirstPlayerSet();
        Integer secondPlayerSet = currentScore.getSecondPlayerSet();

        if(firstPlayerSet == 2 || secondPlayerSet == 2){
            match.setFinished(true);
        }
    }

    private void updateSecondPlayerPoints(Score currentScore){
        Integer firstPlayerPoint = currentScore.getFirstPlayerPoint();
        Integer secondPlayerPoint = currentScore.getSecondPlayerPoint();

        if(secondPlayerPoint < 30) {
            secondPlayerPoint += 15;
        } else if (secondPlayerPoint == 30) {
            secondPlayerPoint += 10;
        } else if(secondPlayerPoint == 40 && firstPlayerPoint < 40) {
            secondPlayerPoint = 0;
            Integer secondPlayerGame = currentScore.getSecondPlayerGame();
            secondPlayerGame++;
            currentScore.setSecondPlayerGame(secondPlayerGame);
            firstPlayerPoint = 0;
        } else if(secondPlayerPoint == 40 && firstPlayerPoint == 40 && currentScore.isSecondPlayerAd()){
            currentScore.setSecondPlayerAd(false);
            secondPlayerPoint = 0;
            Integer secondPlayerGame = currentScore.getSecondPlayerGame();
            secondPlayerGame++;
            currentScore.setSecondPlayerGame(secondPlayerGame);
            firstPlayerPoint = 0;
        } else if(secondPlayerPoint == 40 && firstPlayerPoint == 40 && currentScore.isFirstPlayerAd()){
            currentScore.setFirstPlayerAd(false);
        } else if(secondPlayerPoint == 40 && firstPlayerPoint == 40){
            currentScore.setSecondPlayerAd(true);
            return;
        }
        currentScore.setFirstPlayerPoint(firstPlayerPoint);
        currentScore.setSecondPlayerPoint(secondPlayerPoint);
    }

    private void updateSecondPlayerGames(Score currentScore) {
        Integer firstPlayerGame = currentScore.getFirstPlayerGame();
        Integer secondPlayerGame = currentScore.getSecondPlayerGame();

        List<int[]> setResults = currentScore.getSetResults();
        if(secondPlayerGame < 6 && firstPlayerGame < 6){
            return;
        }
        if(secondPlayerGame == 6 && firstPlayerGame < 5){
            setResults.add(new int[]{firstPlayerGame, secondPlayerGame});
            currentScore.setSecondPlayerGame(0);
            currentScore.setFirstPlayerGame(0);
            Integer secondPlayerSet = currentScore.getSecondPlayerSet();
            secondPlayerSet++;
            currentScore.setSecondPlayerSet(secondPlayerSet);
        } else {
            if((secondPlayerGame - firstPlayerGame) == 2){
                setResults.add(new int[]{firstPlayerGame, secondPlayerGame});
                currentScore.setSecondPlayerGame(0);
                currentScore.setFirstPlayerGame(0);
                Integer secondPlayerSet = currentScore.getSecondPlayerSet();
                secondPlayerSet++;
                currentScore.setSecondPlayerSet(secondPlayerSet);
            }
        }
    }

    private void updateSecondPlayerSets(Score currentScore, Match match){
        Integer firstPlayerSet = currentScore.getFirstPlayerSet();
        Integer secondPlayerSet = currentScore.getSecondPlayerSet();

        if(firstPlayerSet == 2 || secondPlayerSet == 2){
            match.setFinished(true);
        }
    }

    public void renderMatchScorePage(HttpServletRequest req, Match currentMatch,
                                     Player firstPlayer, Player secondPlayer) {
        req.setAttribute("player1Name", firstPlayer.getName());
        req.setAttribute("player2Name", secondPlayer.getName());
        req.setAttribute("firstPlayerId", firstPlayer.getId());
        req.setAttribute("secondPlayerId", secondPlayer.getId());
        req.setAttribute("matchId", currentMatch.getUuid());

        Score currentScore = currentMatch.getCurrentScore();
        if(currentScore.isFirstPlayerAd()){
            req.setAttribute("firstPlayerPoint", "AD");
        } else {
            req.setAttribute("firstPlayerPoint", currentScore.getFirstPlayerPoint());
        }
        if (currentScore.isSecondPlayerAd()){
            req.setAttribute("secondPlayerPoint", "AD");
        } else {
            req.setAttribute("secondPlayerPoint", currentScore.getSecondPlayerPoint());
        }

        req.setAttribute("firstPlayerGame", currentScore.getFirstPlayerGame());
        req.setAttribute("firstPlayerSet", currentScore.getFirstPlayerSet());

        req.setAttribute("secondPlayerGame", currentScore.getSecondPlayerGame());
        req.setAttribute("secondPlayerSet", currentScore.getSecondPlayerSet());
    }

    public void saveCompletedMatch(MatchEntity match) {
        matchDao.saveMatch(match);
    }

    public void renderMatchResultPage(HttpServletRequest req, Match match, Player firstPlayer, Player secondPlayer) {
        Score currentScore = match.getCurrentScore();

        List<int[]> setResults = currentScore.getSetResults();

        req.setAttribute("firstPlayerFirstSet", setResults.get(0)[0]);
        req.setAttribute("firstPlayerSecondSet", setResults.get(1)[0]);

        req.setAttribute("secondPlayerFirstSet", setResults.get(0)[1]);
        req.setAttribute("secondPlayerSecondSet", setResults.get(1)[1]);

        if(setResults.size() == 2) {
            req.setAttribute("firstPlayerThirdSet", "");
            int sets = setResults.get(0)[0] + setResults.get(1)[0];
            req.setAttribute("firstPlayerWinSets", sets);

            sets = setResults.get(0)[1] + setResults.get(1)[1];
            req.setAttribute("secondPlayerWinSets", sets);
            req.setAttribute("secondPlayerThirdSet", "");
        } else {
            req.setAttribute("firstPlayerThirdSet", setResults.get(2)[0]);
            int sets = setResults.get(0)[0] + setResults.get(1)[0] + setResults.get(2)[0];
            req.setAttribute("firstPlayerWinSets", sets);

            req.setAttribute("secondPlayerThirdSet", setResults.get(2)[1]);
            sets = setResults.get(0)[1] + setResults.get(1)[1] + setResults.get(2)[1];
            req.setAttribute("secondPlayerWinSets", sets);
        }

        req.setAttribute("firstPlayerName", firstPlayer.getName());
        req.setAttribute("firstPlayerSets", currentScore.getFirstPlayerSet());

        req.setAttribute("secondPlayerName", secondPlayer.getName());
        req.setAttribute("secondPlayerSets", currentScore.getSecondPlayerSet());
    }
}
