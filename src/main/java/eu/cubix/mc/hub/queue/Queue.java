package eu.cubix.mc.hub.queue;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Queue {

    private static HashMap<Player, Integer> players = new HashMap<>();
    private final String name;
    private final int timer;

    public Queue(String name, HashMap<Player, Integer> players){
        Queue.players = players;
        this.name = name;
        this.timer = 3;
    }

    public static HashMap<Player, Integer> getPlayers(){
        return players;
    }

    public String getName(){
        return name;
    }

    public int getTimer(){
        return timer;
    }

}