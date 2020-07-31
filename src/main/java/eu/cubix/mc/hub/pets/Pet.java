package eu.cubix.mc.hub.pets;

import eu.cubix.mc.hub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;

public class Pet {


    public Pet(){

    }

    public void createPet(Player player,EntityType type){
        if(Main.Pets.containsKey(player.getName())){
            Main.Pets.get(player.getName()).remove();
        }
        Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
        entity.setCustomName(ChatColor.GOLD+player.getName());
        entity.setCustomNameVisible(true);
        Main.Pets.put(player.getName(), entity);
    }

    public void followPlayer(Creature creature,Player player,double Speed){
        Location location = player.getLocation();


        Random rnd = new Random();
        int zufall = rnd.nextInt(6);
        switch(zufall){
            case 0:
                location.add(1.5,0,1.5);
                break;
            case 1:
                location.add(0,0,1.5);
                break;
            case 2:
                location.add(1.5,0,0);
                break;
            case 3:
                location.subtract(1.5,0,1.5);
                break;
            case 4:
                location.subtract(0,0,1.5);
                break;
            case 5:
                location.subtract(1.5,0,0);
                break;
        }


        if(location.distanceSquared(creature.getLocation()) > 50){
            if(!player.isOnGround()){
                return;
            }
            creature.teleport(location);
        }else{
            ((CraftCreature)creature).getHandle().getNavigation().a(location.getX(),location.getY(),location.getZ(),Speed);
        }
    }

}