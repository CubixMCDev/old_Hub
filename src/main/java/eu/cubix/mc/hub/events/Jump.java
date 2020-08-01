package eu.cubix.mc.hub.events;

import eu.cubix.mc.hub.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class Jump implements Listener {

    private Main main;

    public Jump(Main main) {
        this.main = main;
    }

    @EventHandler
    public void doubleJump(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (main.getAPI().get().getRankID(p.getUniqueId()).equals("player")) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
                Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 0));
                if (!b.getType().equals(Material.AIR)) {
                    Vector v = p.getLocation().getDirection().multiply(1).setY(1);
                    p.setVelocity(v);
                }
            }
        }
        if (main.getAPI().get().getRankID(p.getUniqueId()).equals("vip")) {
            // CODE TRIPLE JUMP
        }
        if (main.getAPI().get().getRankID(p.getUniqueId()).equals("vip+")) {
            // CODE QUADRUPLE JUMP
        }
    }
}
