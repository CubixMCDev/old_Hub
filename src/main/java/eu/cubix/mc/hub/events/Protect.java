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
    public void onFallDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onUse(PlayerInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMoveItem(InventoryClickEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteract(EntityInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);

        if (location.getBlockY() <= 0) {
            player.teleport(spawn);
            player.sendMessage("§7Hopopop, vous allez où comme ça ?");
        }
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
    public void noInteractEntity(PlayerInteractEntityEvent e) {
        e.setCancelled(true);
    }
}