package ru.discomfortDeliverer.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.discomfortDeliverer.model.Player;

public class MatchDao {
    private SessionFactory sessionFactory;

    public MatchDao(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();
    }
}
