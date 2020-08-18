package eu.cubix.mc.hub.task;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AntiAFK extends BukkitRunnable {

    private int timer;

    private final Player player;

    private Block block;

    public AntiAFK(Player player, Block locBlock) {
        this.timer = 900;
        this.player = player;
        this.block = locBlock;
    }

    @Override
    public void run() {
        timer--;

        if(timer == 0) {
            if((block.getX() == player.getLocation().getBlock().getX()) && (block.getZ() == player.getLocation().getBlock().getZ())) {
                player.kickPlayer("§cVous avez été éjecté pour AFK! §4(15 minutes)");
            }
        }

        if((block.getX() != player.getLocation().getBlock().getX()) && (block.getZ() != player.getLocation().getBlock().getZ())) {
            timer = 900;
            block = player.getLocation().getBlock();
        }
    }
}
