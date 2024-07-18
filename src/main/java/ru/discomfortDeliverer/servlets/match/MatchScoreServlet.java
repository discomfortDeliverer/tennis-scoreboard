package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.dto.MatchDTO;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.Player;
import ru.discomfortDeliverer.model.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        MatchDTO currentMatchDTO = matches.get(uuid);

        Player firstPlayer = playerService.findPlayerById(currentMatchDTO.getFirstPlayerId());
        Player secondPlayer = playerService.findPlayerById(currentMatchDTO.getSecondPlayerId());

        matchService.renderMatchScorePage(req, currentMatchDTO, firstPlayer, secondPlayer);
        req.getRequestDispatcher("/WEB-INF/jsp/matchScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MatchDTO currentMatchDTO = matches.get(UUID.fromString(req.getParameter("uuid")));

        Integer playerWinPointId = Integer.parseInt(req.getParameter("player_id"));
        matchService.updateMatchScore(currentMatchDTO, playerWinPointId);

        Player firstPlayer = playerService.findPlayerById(currentMatchDTO.getFirstPlayerId());
        Player secondPlayer = playerService.findPlayerById(currentMatchDTO.getSecondPlayerId());
        if (!currentMatchDTO.isFinished()){
            matchService.renderMatchScorePage(req, currentMatchDTO, firstPlayer, secondPlayer);
        } else {
            matches.remove(currentMatchDTO.getUuid());
            Match match = new Match();
            match.setFirstPlayer(firstPlayer);
            match.setSecondPlayer(secondPlayer);

            Score currentScore = currentMatchDTO.getCurrentScore();
            Integer firstPlayerSet = currentScore.getFirstPlayerSet();
            Integer secondPlayerSet = currentScore.getSecondPlayerSet();

            if(firstPlayerSet > secondPlayerSet){
                match.setWinner(firstPlayer);
            } else {
                match.setWinner(secondPlayer);
            }

            matchService.saveCompletedMatch(match);

            matchService.renderMatchResultPage(req, currentMatchDTO, firstPlayer, secondPlayer);

            req.getRequestDispatcher("/WEB-INF/jsp/matchResultPage.jsp").forward(req, resp);
        }
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/matchScore.jsp").forward(req, resp);
    }
}
