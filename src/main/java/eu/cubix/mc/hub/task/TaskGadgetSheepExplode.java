package eu.cubix.mc.hub.task;

import eu.cubix.mc.hub.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskGadgetSheepExplode extends BukkitRunnable {
    private final Main main;
    private final Player player;

    int timer = 2;

    public TaskGadgetSheepExplode(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    @Override
    public void run() {
        if(timer == 0) {
            main.getAPI().set().removeCoins(player.getUniqueId(), 10);
            player.sendMessage("§eCubixMC §6» §eAchat confirmé. Merci pour votre confiance !");
            main.getCosmeticsManager().setCosmeticSQL("gadgetSheepExplode",true,player.getUniqueId());
            this.cancel();
        }

        timer--;
    }
}
