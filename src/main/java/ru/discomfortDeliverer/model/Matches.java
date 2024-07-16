package ru.discomfortDeliverer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Player1")
    private Player firstPlayer;
    @ManyToOne
    @JoinColumn(name = "Player2")
    private Player secondPlayer;
    @OneToOne
    @JoinColumn(name = "Winner")
    private Player winner;

}
