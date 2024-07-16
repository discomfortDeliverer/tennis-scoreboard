package ru.discomfortDeliverer.servlets;

import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.Player;
import ru.discomfortDeliverer.service.NewMatchService;
import ru.discomfortDeliverer.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private NewMatchService newMatchService= new NewMatchService();
    private PlayerService playerService = new PlayerService();
    private Map<UUID, Match> matches = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/jsp/simplePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");

        String firstPlayerName = req.getParameter("player1");
        String secondPlayerName = req.getParameter("player2");

        Player firstPlayer = new Player();
        firstPlayer.setName(firstPlayerName);

        Player secondPlayer = new Player();
        secondPlayer.setName(secondPlayerName);

        playerService.createPlayerIfNotExists(firstPlayer);
        playerService.createPlayerIfNotExists(secondPlayer);

        Match newMatch = new Match();
        newMatch.setFirstPlayerId(firstPlayer.getId());
        newMatch.setSecondPlayerId(secondPlayer.getId());

        matches.put(newMatch.getUuid(), newMatch);

        resp.sendRedirect("/tennis-scoreboard/match-score?uuid=" + newMatch.getUuid());
    }
}
