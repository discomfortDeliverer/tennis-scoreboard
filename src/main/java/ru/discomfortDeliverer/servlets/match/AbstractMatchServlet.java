package ru.discomfortDeliverer.servlets.match;

import ru.discomfortDeliverer.model.Match;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbstractMatchServlet extends HttpServlet {
    protected Map<UUID, Match> matches = new HashMap<>();
}
