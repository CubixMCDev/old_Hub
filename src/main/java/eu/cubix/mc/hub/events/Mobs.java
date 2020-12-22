package eu.cubix.mc.hub.events;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

public class Mobs implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if(e.getEntity().getType() == EntityType.HORSE) {
            Horse horse = (Horse) e.getEntity();
            horse.setTamed(true);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        }
        if(e.getEntity().getType() == EntityType.PIG) {
            Pig pig = (Pig) e.getEntity();
            pig.setSaddle(true);
        }

        /*
        if(e.getEntity().getType() == EntityType.SHEEP) {
            Sheep sheep = (Sheep) e.getEntity();
            sheep.setCustomName("jeb_");
            sheep.setCustomNameVisible(false);
        }
         */
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void NoTarget(EntityTargetEvent e) {
        if (e.getEntityType().equals(EntityType.BLAZE)
                || (e.getEntityType().equals(EntityType.CAVE_SPIDER)
                || (e.getEntityType().equals(EntityType.CREEPER)
                || (e.getEntityType().equals(EntityType.ENDERMAN)
                || (e.getEntityType().equals(EntityType.GHAST)
                || (e.getEntityType().equals(EntityType.WITHER)
                || (e.getEntityType().equals(EntityType.ENDER_DRAGON)
                || (e.getEntityType().equals(EntityType.MAGMA_CUBE)
                || (e.getEntityType().equals(EntityType.PIG_ZOMBIE)
                || (e.getEntityType().equals(EntityType.SILVERFISH)
                || (e.getEntityType().equals(EntityType.SKELETON)
                || (e.getEntityType().equals(EntityType.SLIME)
                || (e.getEntityType().equals(EntityType.SPIDER)
                || (e.getEntityType().equals(EntityType.ZOMBIE))))))))))))))) {
            if (e.getTarget() instanceof Player) {
                Player player = (Player) e.getTarget();
                String playername = player.getName();
                if (playername.equals("SomeName")) e.setTarget(null);

            }
        }
        e.setCancelled(true);
        e.getEntity().setFireTicks(0);
    }

    @EventHandler
    public void noMobBurn(EntityCombustByBlockEvent e) {
        e.setCancelled(true);
    }
}
