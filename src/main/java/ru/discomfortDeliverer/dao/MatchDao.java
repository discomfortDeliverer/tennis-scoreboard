package ru.discomfortDeliverer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.discomfortDeliverer.model.Match;
import ru.discomfortDeliverer.model.MatchEntity;
import ru.discomfortDeliverer.model.Player;

public class MatchDao {
    private SessionFactory sessionFactory;

    public MatchDao(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();
    }

    public void saveMatch(MatchEntity match) {

        Session session = sessionFactory.openSession();

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
}
