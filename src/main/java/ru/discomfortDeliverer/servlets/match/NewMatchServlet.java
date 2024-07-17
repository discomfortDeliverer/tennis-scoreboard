package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.dto.MatchDTO;
import ru.discomfortDeliverer.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends AbstractMatchServlet {
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

        MatchDTO newMatchDTO = new MatchDTO();
        newMatchDTO.setFirstPlayerId(firstPlayer.getId());
        newMatchDTO.setSecondPlayerId(secondPlayer.getId());

        matches.put(newMatchDTO.getUuid(), newMatchDTO);

        resp.sendRedirect("/tennis-scoreboard/match-score?uuid=" + newMatchDTO.getUuid());
    }
}
