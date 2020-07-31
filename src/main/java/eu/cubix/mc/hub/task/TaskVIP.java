package eu.cubix.mc.hub.task;

import eu.cubixmc.com.ranks.Ranks;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static eu.cubix.mc.hub.Main.api;

public class TaskVIP extends BukkitRunnable {
    private final Player player;

    int timer = 2;

    public TaskVIP(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        if(timer == 0) {
            api.getEcoManager().removeCredits(player, 4650);
            player.sendMessage("§eCubixMC §6» §eAchat confirmé. Merci pour votre confiance !");
            api.getRankManager().setRank(player, Ranks.VIP);
            this.cancel();
        }

        timer--;
    }
}
