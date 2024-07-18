package ru.discomfortDeliverer.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.discomfortDeliverer.model.Player;

public abstract class BaseDao {
    protected SessionFactory sessionFactory;

    public BaseDao(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
