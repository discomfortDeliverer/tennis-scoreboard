package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.dao.PlayerDao;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.MatchEntity;
import ru.discomfortDeliverer.model.Player;
import ru.discomfortDeliverer.model.Score;
import ru.discomfortDeliverer.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score")
public class MatchScoreServlet extends AbstractMatchServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        Match currentMatch = matches.get(uuid);

        Player firstPlayer = playerService.findPlayerById(currentMatch.getFirstPlayerId());
        Player secondPlayer = playerService.findPlayerById(currentMatch.getSecondPlayerId());

        req.setAttribute("player1Name", firstPlayer.getName());
        req.setAttribute("player2Name", secondPlayer.getName());
        req.setAttribute("firstPlayerId", firstPlayer.getId());
        req.setAttribute("secondPlayerId", secondPlayer.getId());
        req.setAttribute("matchId", currentMatch.getUuid());

        req.setAttribute("firstPlayerPoint", 0);
        req.setAttribute("firstPlayerSet", 0);
        req.setAttribute("firstPlayerGame", 0);

        req.setAttribute("secondPlayerPoint", 0);
        req.setAttribute("secondPlayerSet", 0);
        req.setAttribute("secondPlayerGame", 0);
        req.getRequestDispatcher("/WEB-INF/jsp/matchScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Match currentMatch = matches.get(UUID.fromString(req.getParameter("uuid")));

        Integer playerWinPointId = Integer.parseInt(req.getParameter("player_id"));
        matchService.updateMatchScore(currentMatch, playerWinPointId);

        Player firstPlayer = playerService.findPlayerById(currentMatch.getFirstPlayerId());
        Player secondPlayer = playerService.findPlayerById(currentMatch.getSecondPlayerId());
        if (!currentMatch.isFinished()){
            matchService.renderMatchScorePage(req, currentMatch, firstPlayer, secondPlayer);
        } else {
            matches.remove(currentMatch.getUuid());
            MatchEntity match = new MatchEntity();
            match.setFirstPlayer(firstPlayer);
            match.setSecondPlayer(secondPlayer);

            Score currentScore = currentMatch.getCurrentScore();
            Integer firstPlayerSet = currentScore.getFirstPlayerSet();
            Integer secondPlayerSet = currentScore.getSecondPlayerSet();

            if(firstPlayerSet > secondPlayerSet){
                match.setWinner(firstPlayer);
            } else {
                match.setWinner(secondPlayer);
            }

            matchService.saveCompletedMatch(match);

            matchService.renderMatchResultPage(req, currentMatch, firstPlayer, secondPlayer);

            req.getRequestDispatcher("/WEB-INF/jsp/matchResultPage.jsp").forward(req, resp);
        }
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/matchScore.jsp").forward(req, resp);
    }
}
