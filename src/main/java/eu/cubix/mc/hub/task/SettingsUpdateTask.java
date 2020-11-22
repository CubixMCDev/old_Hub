package eu.cubix.mc.hub.task;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.inventory.Settings;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SettingsUpdateTask extends BukkitRunnable {
    private final Main main;
    private final Player player;

    int timer = 2;

    public SettingsUpdateTask(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    @Override
    public void run() {
        if(timer == 0) {
            player.sendMessage("§eCubixMC §6» §eParamètres chargé !");
            main.getGuiManager().open(player, Settings.class);
            this.cancel();
        }

        timer--;
    }
}
