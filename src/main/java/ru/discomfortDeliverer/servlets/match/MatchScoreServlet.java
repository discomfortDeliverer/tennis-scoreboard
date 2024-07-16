package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.dao.PlayerDao;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.Player;
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
        req.getRequestDispatcher("/WEB-INF/jsp/matchScore.jsp").forward(req, resp);
    }
}
