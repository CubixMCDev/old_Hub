package eu.cubix.mc.hub.task;

import eu.cubix.mc.hub.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskVIP extends BukkitRunnable {

    private Main main;
    private final Player player;

    int timer = 2;

    public TaskVIP(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    @Override
    public void run() {
        if(timer == 0) {
            main.getAPI().set().removeCredits(player.getUniqueId(), 4650);
            player.sendMessage("§eCubixMC §6» §eAchat confirmé. Merci pour votre confiance !");
            main.getAPI().set().setRank(player.getUniqueId(), "vip", false);
            this.cancel();
        }

        timer--;
    }
}
