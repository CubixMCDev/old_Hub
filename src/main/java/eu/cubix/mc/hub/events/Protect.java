package eu.cubix.mc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Protect implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onMoveItem(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onInteract(EntityInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);

        if (location.getBlockY() <= 0) {
            player.teleport(spawn);
            player.sendMessage("§7Hopopop, vous allez où comme ça ?");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void NoTarget(EntityTargetEvent event) {
        if (event.getEntityType().equals(EntityType.BLAZE)
                || (event.getEntityType().equals(EntityType.CAVE_SPIDER)
                || (event.getEntityType().equals(EntityType.CREEPER)
                || (event.getEntityType().equals(EntityType.ENDERMAN)
                || (event.getEntityType().equals(EntityType.GHAST)
                || (event.getEntityType().equals(EntityType.WITHER)
                || (event.getEntityType().equals(EntityType.ENDER_DRAGON)
                || (event.getEntityType().equals(EntityType.MAGMA_CUBE)
                || (event.getEntityType().equals(EntityType.PIG_ZOMBIE)
                || (event.getEntityType().equals(EntityType.SILVERFISH)
                || (event.getEntityType().equals(EntityType.SKELETON)
                || (event.getEntityType().equals(EntityType.SLIME)
                || (event.getEntityType().equals(EntityType.SPIDER)
                || (event.getEntityType().equals(EntityType.ZOMBIE))))))))))))))) {
            if (event.getTarget() instanceof Player) {
                Player player = (Player) event.getTarget();
                String playername = player.getName();
                if (playername.equals("SomeName")) event.setTarget(null);

            }
        }
        event.setCancelled(true);
        event.getEntity().setFireTicks(0);
    }

    @EventHandler
    public void noShears(PlayerShearEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noMilk(PlayerInteractAtEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noSpawnItem(ItemSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noInteractEntity(PlayerInteractEntityEvent event) {
        event.setCancelled(true);
    }
}