package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.model.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesServlet extends AbstractMatchServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterByPlayerName = req.getParameter("filter_by_player_name");

        if (filterByPlayerName == null || filterByPlayerName.isEmpty()){
            req.getRequestDispatcher("/WEB-INF/jsp/findMatchesByPlayerNamePage.jsp").forward(req, resp);
            return;
        }

        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("size"));
        List<Match> matchesByPlayerName = matchService.findMatchesByPlayerName(filterByPlayerName, page, size);

        for (Match entity : matchesByPlayerName) {
            System.out.println(entity);
        }

        req.setAttribute("matches", matchesByPlayerName);
        req.setAttribute("currentPage", page);
        req.setAttribute("pageSize", size);
        req.getRequestDispatcher("/WEB-INF/jsp/paginatedResults.jsp").forward(req, resp);
    }
}
