package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.dto.MatchDTO;
import ru.discomfortDeliverer.service.MatchService;
import ru.discomfortDeliverer.service.PlayerService;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractMatchServlet extends HttpServlet {
    protected static Map<UUID, MatchDTO> matches = new HashMap<>();
    protected static PlayerService playerService = new PlayerService();
    protected static MatchService matchService = new MatchService();
}
