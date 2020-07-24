package eu.cubix.mc.hub.events;

import fr.cubixmc.api.ranks.Ranks;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import static eu.cubix.mc.hub.Main.api;

public class Jump implements Listener {

    @EventHandler
    public void doubleJump(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (api.getRankManager().getRank(p) == Ranks.PLAYER) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
                Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 0));
                if (!b.getType().equals(Material.AIR)) {
                    Vector v = p.getLocation().getDirection().multiply(1).setY(1);
                    p.setVelocity(v);
                }
            }
        }
        if (api.getRankManager().getRank(p) == Ranks.VIP) {

        }
        if (api.getRankManager().getRank(p) == Ranks.VIPPLUS) {

        }
    }
}
