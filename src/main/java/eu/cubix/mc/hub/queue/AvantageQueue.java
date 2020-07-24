package eu.cubix.mc.hub.queue;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class AvantageQueue {

    private final HashMap<Player, Integer> players;
    private final String name;
    private final int timer;

    public AvantageQueue(String name, HashMap<Player, Integer> players){
        this.players = players;
        this.name = name;
        this.timer = 1;
    }

    public HashMap<Player, Integer> getPlayers(){
        return players;
    }

    public String getName(){
        return name;
    }

    public int getTimer(){
        return timer;
    }
}
