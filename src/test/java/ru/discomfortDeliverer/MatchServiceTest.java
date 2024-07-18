package ru.discomfortDeliverer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.discomfortDeliverer.dto.MatchDTO;
import ru.discomfortDeliverer.model.Score;
import ru.discomfortDeliverer.service.MatchService;

import static org.junit.jupiter.api.Assertions.*;

public class MatchServiceTest{
    private MatchService matchService;
    private MatchDTO currentMatchDTO;
    private Integer playerWinPointId;
    private Score score;

    @BeforeEach
    public void setUp() throws Exception {
        matchService = new MatchService();
        currentMatchDTO = new MatchDTO();
        playerWinPointId = null;
        score = new Score();
    }

    @Test
    public void updateMatchScore_GameShouldContinue(){
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(40);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;


        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertTrue(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(40, score.getFirstPlayerPoint());
        assertEquals(40, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_WhenFirstPlayerWinPointWhen40_0HeWinGame(){
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(0);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;


        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(1, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_WhenScoreIs6_6StartsTieBrake(){
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(0);
        score.setFirstPlayerGame(6);
        score.setSecondPlayerGame(6);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(7, score.getFirstPlayerGame());
        assertEquals(6, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_WhilePointsLessThan30AdditionalPointsEquals15(){
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        // 15:0
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(15, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // 30:0
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(30, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // 30:15
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(30, score.getFirstPlayerPoint());
        assertEquals(15, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // 30:30
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(30, score.getFirstPlayerPoint());
        assertEquals(30, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_WhilePointsMoreThan30AdditionalPointsEquals10() {
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        // 40:30
        score.setFirstPlayerPoint(30);
        score.setSecondPlayerPoint(30);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(40, score.getFirstPlayerPoint());
        assertEquals(30, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // 40:40
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(40, score.getFirstPlayerPoint());
        assertEquals(40, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_40_40Advantage() {
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        // FirstPlayer = 40, SecondPlayer < 40
        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(30);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(1, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // FirstPlayer = 40, SecondPlayer = 40 => FirstPlayer AD
        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(40);
        score.setFirstPlayerGame(0);
        score.setSecondPlayerGame(0);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertTrue(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(40, score.getFirstPlayerPoint());
        assertEquals(40, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // FirstPlayer = 40, AD, SecondPlayer = 40 => FirstPlayer win game
        score.setFirstPlayerAd(true);
        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(40);
        score.setFirstPlayerGame(0);
        score.setSecondPlayerGame(0);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(1, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());

        // FirstPlayer = 40, SecondPlayer = 40, AD => 40:40
        score.setSecondPlayerAd(true);
        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(40);
        score.setFirstPlayerGame(0);
        score.setSecondPlayerGame(0);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(40, score.getFirstPlayerPoint());
        assertEquals(40, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
    }

    @Test
    public void updateMatchScore_FirstAndSecondPlayersGameLessThan6() {
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(30);
        score.setFirstPlayerGame(5);
        score.setSecondPlayerGame(5);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(6, score.getFirstPlayerGame());
        assertEquals(5, score.getSecondPlayerGame());
        assertEquals(0, score.getFirstPlayerSet());
        assertEquals(0, score.getSecondPlayerSet());
    }

    @Test
    public void updateMatchScore_FirstPlayerGameIs6AndSecondPlayersGameLessThan5() {
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(30);
        score.setFirstPlayerGame(5);
        score.setSecondPlayerGame(4);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
        assertEquals(1, score.getFirstPlayerSet());
        assertEquals(0, score.getSecondPlayerSet());
    }

    @Test
    public void updateMatchScore_TieBrakeTest() {
        currentMatchDTO.setFirstPlayerId(0);
        currentMatchDTO.setSecondPlayerId(1);

        score.setFirstPlayerPoint(40);
        score.setSecondPlayerPoint(30);
        score.setFirstPlayerGame(5);
        score.setSecondPlayerGame(5);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 0;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(6, score.getFirstPlayerGame());
        assertEquals(5, score.getSecondPlayerGame());
        assertEquals(0, score.getFirstPlayerSet());
        assertEquals(0, score.getSecondPlayerSet());

        score.setFirstPlayerPoint(30);
        score.setSecondPlayerPoint(40);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(6, score.getFirstPlayerGame());
        assertEquals(6, score.getSecondPlayerGame());
        assertEquals(0, score.getFirstPlayerSet());
        assertEquals(0, score.getSecondPlayerSet());

        score.setFirstPlayerPoint(30);
        score.setSecondPlayerPoint(40);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(6, score.getFirstPlayerGame());
        assertEquals(7, score.getSecondPlayerGame());
        assertEquals(0, score.getFirstPlayerSet());
        assertEquals(0, score.getSecondPlayerSet());

        score.setFirstPlayerPoint(30);
        score.setSecondPlayerPoint(40);
        currentMatchDTO.setCurrentScore(score);
        playerWinPointId = 1;

        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);
        assertFalse(score.isFirstPlayerAd());
        assertFalse(score.isSecondPlayerAd());
        assertEquals(0, score.getFirstPlayerPoint());
        assertEquals(0, score.getSecondPlayerPoint());
        assertEquals(0, score.getFirstPlayerGame());
        assertEquals(0, score.getSecondPlayerGame());
        assertEquals(0, score.getFirstPlayerSet());
        assertEquals(1, score.getSecondPlayerSet());
    }
}
