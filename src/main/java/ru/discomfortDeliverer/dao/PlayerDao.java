package ru.discomfortDeliverer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.discomfortDeliverer.model.Player;

import java.util.List;

public class PlayerDao {
    private SessionFactory sessionFactory;

    public PlayerDao(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .buildSessionFactory();
    }

    private boolean isPlayerExists(Player player){
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            String hql = "FROM Player WHERE name = :playerName";
            Query query = session.createQuery(hql);
            query.setParameter("playerName", player.getName());

            List<Player> players = query.list();

            if(players.isEmpty()){
                return false;
            } else {
                Player existedPlayer = players.get(0);
                player.setId(existedPlayer.getId());
                return true;
            }
        } finally {
            session.close();
        }
    }

    private void findAllPlayers(){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            List<Player> players = session.createQuery("FROM Player").getResultList();

            int i=1;
            for (Player player : players) {
                System.out.println(i + ") " + player.getId() + " " + player.getName());
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void createPlayerIfNotExists(Player player) {
        if(!isPlayerExists(player)){
            Session session = sessionFactory.openSession();

            try{
                session.beginTransaction();

                Integer id = (Integer) session.save(player);

                player.setId(id);
                session.getTransaction().commit();

                System.out.println("Игрок " + player.getName() + " сохранен в бд");
                findAllPlayers();
            } finally {
                session.close();
            }
        }
    }

    public Player findPlayerById(Integer playerId) {
        findAllPlayers();

        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

            Player player = session.get(Player.class, playerId);

            session.getTransaction().commit();

            return player;
        } finally {
            session.close();
        }
    }
}
