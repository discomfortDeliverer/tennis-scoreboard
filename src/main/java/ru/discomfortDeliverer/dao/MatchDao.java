package ru.discomfortDeliverer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.Player;

import java.util.List;

public class MatchDao extends BaseDao{

    public void saveMatch(Match match) {

        Session session = getSessionFactory().openSession();

        try{
            session.beginTransaction();

            Integer id = (Integer) session.save(match);

            match.setId(id);
            session.getTransaction().commit();

            System.out.println("Матч " + match.getId() + " сохранен в бд");
        } finally {
            session.close();
        }

    }

    public List<Match> findMatchesByPlayerName(String playerName, int page, int size) {
        Session session = getSessionFactory().openSession();
        String hql = "SELECT m FROM Match m JOIN m.firstPlayer p1 JOIN m.secondPlayer p2 WHERE p1.name = :playerName OR p2.name = :playerName";
        Query query = session.createQuery(hql, Match.class);
        query.setParameter("playerName", playerName);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);

        List<Match> matches = query.list();

        session.close();
        return matches;
    }
}
